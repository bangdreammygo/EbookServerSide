package com.ebook.repository;

import com.ebook.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem,Long> {
//    根据用户信息和书籍id获取购物车中的某一项
    @Query(value = "select * from tb_cart where userid = ?1 and bookid = ?2",nativeQuery = true)
    public CartItem findCartItem(Long userid,Long bookid);
//    根据用户id获取全部信息、
    @Query(value = "select * from tb_cart where userid = ?1",nativeQuery = true)
    public List<CartItem>  findAllByUserid(Long userid);
//    通过id查找购物车项
    @Query(value = "select * from tb_cart where id = ?1",nativeQuery = true)
    public CartItem findByid(Long id);
}
