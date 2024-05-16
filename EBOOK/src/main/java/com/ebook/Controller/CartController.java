package com.ebook.Controller;
import com.ebook.entity.CartItem;
import com.ebook.entity.OrderEntity;
import com.ebook.entity.OrderItem;
import com.ebook.dto.BooksWithNum;
import com.ebook.dto.BooksWithOrder;
import com.ebook.pojo.Result;
import com.ebook.service.BookService;
import com.ebook.service.CartService;
import com.ebook.service.OrderService;
import com.ebook.service.UserService;
import com.ebook.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//购物车的后端controller
@RestController
@CrossOrigin
//监听事务的回滚
@Transactional
public class CartController {
//    获取用户、购物车、书籍、订单的四个服务
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

//    将编号bookid的书籍加入购物车
    @RequestMapping("/cart/add")
    public Result addCart(Long bookid,String token) {
//        先解析用户的token
        Claims claims = JWTUtil.parseJwt(token);
        //获取到用户的id
        Long userId = claims.get("id",Long.class);
        boolean flag=cartService.checkIfExist(userId,bookid);
        if(flag){
//            已经存在了
            return new Result(200,"fail","该书此前已经添加至购物车");
        }
//        不存在
        CartItem newitem=new CartItem();
        newitem.setNum(1);
        newitem.setUserid(userId);
        newitem.setBookid(bookid);
        cartService.addCartItem(newitem);
        return new Result(200,"success","成功添加至购物车！");
    }

//    根据用户信息查找该用户的当前购物车
    @RequestMapping("/cart/get")
    public Result getCart(String token) {
        //解析token
        Claims claims = JWTUtil.parseJwt(token);
        //获取用户id
        Long userId = claims.get("id",Long.class);
        //根据用户的id查找购物车
        List<CartItem>cart=cartService.getAllCartItems(userId);
        List<BooksWithNum>res=new ArrayList<>();
        //遍历循环
        for (CartItem cartItem : cart) {
            BooksWithNum booksWithNum=new BooksWithNum();
            booksWithNum.setNum(cartItem.getNum());
            booksWithNum.setBook(bookService.findBookById(cartItem.getBookid()));
            res.add(booksWithNum);
        }
        return new Result(200,"success",res);
    }
//    删除购物车项
    @RequestMapping("/cart/delete")
    public Result deleteCart(String token,Long bookid) {
        Claims claims = JWTUtil.parseJwt(token);
        Long userId = claims.get("id",Long.class);
        CartItem cartItem=cartService.getCartItem(userId,bookid);
        cartService.deleteCartItem(cartItem);
        return new Result(200,"success","已删除");
    }


//    提交购物车订单
    @RequestMapping("/cart/buy")
    public Result buyCart(@RequestParam String token, @RequestBody BooksWithOrder orderPost) {
        //获取用户信息
        Claims claims = JWTUtil.parseJwt(token);
        Long userId = claims.get("id",Long.class);
        //生成时间
        orderPost.setOrderdate(LocalDateTime.now());
        //获取当前订单的书籍信息
        List<BooksWithNum>books=orderPost.getBooks();
        //遍历查看是否符合库存要求
        boolean flag=true;
        Long totalprice=0L;
        for (BooksWithNum booksWithNum : books) {
            //获取num
            int num=booksWithNum.getNum();
            totalprice+=(booksWithNum.getBook().getPrice()*num);
            //获取书籍id
            Long bookid=booksWithNum.getBook().getId();
            //查看库存
            int rest=bookService.findBookById(bookid).getRest();
            if(rest<num){
                flag=false;
                break;
            }
        }
//        库存不足！
        if(!flag){
//            删除该用户的订单，并返回错误！
            for (BooksWithNum booksWithNum : books) {
                CartItem cart =cartService.getCartItem(userId,booksWithNum.getBook().getId());
                cartService.deleteCartItem(cart);
            }
            return new Result(444,"error","库存不足！");
        }
//        余额不足
//        查看用户存款
        Long money=userService.getUserById(userId).getMoney();
        if(money<totalprice){
//            删除该用户的订单，并返回错误！
            for (BooksWithNum booksWithNum : books) {
                CartItem cart =cartService.getCartItem(userId,booksWithNum.getBook().getId());
                cartService.deleteCartItem(cart);
            }
            return new Result(444,"error","账户余额不足！");
        }
//        余额充足，那就扣钱
        userService.getUserById(userId).setMoney(money-totalprice);
//        库存充足，那么既要生成新订单，又要删除库存，还要删除购物车
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setUserid(userId);
        orderEntity.setPhone(orderPost.getPhone());
        orderEntity.setAddress(orderPost.getAddress());
        orderEntity.setReceiver(orderPost.getReceiver());
        orderEntity.setOrderdate(orderPost.getOrderdate());
//        生成新的订单项列表
        List<OrderItem>orderItems=new ArrayList<OrderItem>();
        for (BooksWithNum booksWithNum : books) {
            OrderItem orderItem=new OrderItem();
            //获取num
            int num=booksWithNum.getNum();
            //获取书籍id
            Long bookid=booksWithNum.getBook().getId();
            //获取当前库存
            int rest=bookService.findBookById(bookid).getRest();
            //修改库存
            rest=rest-num;
            bookService.findBookById(bookid).setRest(rest);
            //设置订单项
            orderItem.setBook_id(bookid);
            orderItem.setNum(num);
            orderItem.setOrder(orderEntity);
            orderItems.add(orderItem);
            //删除购物车
            CartItem cart =cartService.getCartItem(userId,booksWithNum.getBook().getId());
            cartService.deleteCartItem(cart);
        }
        orderEntity.setOrderitems(orderItems);
//        将订单存入数据库
        orderService.addOrder(orderEntity);
        return new Result(200,"success","订单已提交！");
    }


//    更新购物车数目
    @RequestMapping("/cart/update")
    public Result updateCart(String token,Long bookid, int num) {
        //获取用户id
        Claims claims = JWTUtil.parseJwt(token);
        Long userId = claims.get("id",Long.class);
        CartItem cartItem=cartService.getCartItem(userId,bookid);
        cartItem.setNum(num);
        cartService.updateCartItem(cartItem);
        return new Result(200,"success",cartItem);
    }


}