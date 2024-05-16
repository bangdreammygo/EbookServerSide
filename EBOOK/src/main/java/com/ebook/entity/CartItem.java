package com.ebook.entity;

//映射购物车


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_cart")
public class CartItem {
//    购物车项本身的id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    该购物车属于的用户id
    @Column(name = "userid")
    private Long userid;
//    该项买的是哪本书
    @Column(name = "bookid")
    private Long bookid;
//    买了几本书
    @Column(name = "num")
    private Integer num;
}
