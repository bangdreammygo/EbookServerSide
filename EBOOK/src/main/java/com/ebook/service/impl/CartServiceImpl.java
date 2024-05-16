package com.ebook.service.impl;


import com.ebook.entity.CartItem;
import com.ebook.repository.CartRepository;
import com.ebook.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository CartRepository;
// 增加
    @Override
   public CartItem addCartItem(CartItem cartItem){
        return CartRepository.save(cartItem);
    }
//    修改
    @Override public CartItem updateCartItem(CartItem cartItem){
        return CartRepository.save(cartItem);
    }
//    删除
    @Override
    public void deleteCartItem(CartItem cartItem){
          CartRepository.delete(cartItem);
    }
    @Override
//    通过id查找购物车项
    public CartItem findCartItem(Long id) {
        return CartRepository.findByid(id);
    }
//    查看是否已经存在
    @Override
    public  boolean checkIfExist(Long userid ,Long bookid){
        CartItem res=CartRepository.findCartItem(userid,bookid);
        if(res!=null){
            return true;
        }
        return false;
    }
//    获取整个购物车
    @Override
    public List<CartItem> getAllCartItems(Long userid){
        return CartRepository.findAllByUserid(userid);
    }
//    通过用户信息和书籍信息获取购物车项
    @Override
    public CartItem getCartItem(Long userid,Long bookid){
        return CartRepository.findCartItem(userid,bookid);
    }
}
