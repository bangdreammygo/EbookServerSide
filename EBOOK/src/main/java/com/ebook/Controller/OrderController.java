package com.ebook.Controller;


//用来获取订单的后端接口
import com.ebook.entity.BookEntity;
import com.ebook.entity.OrderEntity;
import com.ebook.entity.OrderItem;
import com.ebook.dto.BooksWithNum;
import com.ebook.dto.BooksWithOrder;
import com.ebook.pojo.Result;
import com.ebook.service.BookService;
import com.ebook.service.OrderService;
import com.ebook.service.UserService;
import com.ebook.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
//监听事务的回滚
@Transactional
public class OrderController {
    //获取用户、书籍、订单三个服务
    @Autowired
    private OrderService orderService;
    @Autowired
    private BookService bookService;


    //获取订单
    @RequestMapping("/order/get")
    public Result getOrder(String token) {
        //解析token
        Claims claims = JWTUtil.parseJwt(token);
        //获取用户id
        Long userId = claims.get("id",Long.class);
        //获取用户的所有order
        List<OrderEntity>orderEntities=orderService.getUserOrder(userId);
        //如果还没有订单信息，则返回空数组
        if(orderEntities.isEmpty())return new Result(200,"success",new ArrayList<OrderEntity>());
        //否则就要装填信息
        List<BooksWithOrder>res=new ArrayList<BooksWithOrder>();
        for(OrderEntity order:orderEntities){
            BooksWithOrder booksWithOrder=new BooksWithOrder();
            booksWithOrder.setOrderid(order.getId());
            booksWithOrder.setReceiver(order.getReceiver());
            booksWithOrder.setAddress(order.getAddress());
            booksWithOrder.setPhone(order.getPhone());
            booksWithOrder.setOrderdate(order.getOrderdate());
            //获取订单项
            List<OrderItem>orderItems=order.getOrderitems();
            //装填该项订单的书籍信息
            List<BooksWithNum>booksWithNums=new ArrayList<BooksWithNum>();
            for(OrderItem orderItem:orderItems){
                BooksWithNum booksWithNum=new BooksWithNum();
                int num=orderItem.getNum();
                booksWithNum.setNum(num);
                Long bookid=orderItem.getBook_id();
                BookEntity book=bookService.findBookById(bookid);
                booksWithNum.setBook(book);
                booksWithNums.add(booksWithNum);
            }
            //装填完毕信息
            booksWithOrder.setBooks(booksWithNums);
            res.add(booksWithOrder);
        }
        //获取到所有订单信息！
        return new Result(200,"success",res);
    }





}
