package com.ebook.service;


import com.ebook.entity.CartItem;

import java.util.List;

public interface CartService {
//    增
    public CartItem addCartItem(CartItem cartItem);
//    改
    public CartItem updateCartItem(CartItem cartItem);
//    删
    public void deleteCartItem(CartItem cartItem);
//    通过id查找购物车项
    public CartItem findCartItem(Long id);
//    查是否存在
    public boolean checkIfExist(Long userid ,Long bookid);
//    获取整个购物车
    public List<CartItem> getAllCartItems(Long userid);
//    通过用户信息和书籍信息获取购物车项
    public CartItem getCartItem(Long userid,Long bookid);
}
