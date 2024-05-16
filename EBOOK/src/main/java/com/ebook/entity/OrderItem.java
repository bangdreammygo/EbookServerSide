package com.ebook.entity;

//映射orderitem表
//标识订单中的某一项

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_orderitem")
public class OrderItem {
//    订单项的主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
//    该订单项的书籍id
    @Column(name = "book_id")
    private Long book_id;
//    买了几本书
    @Column(name = "num")
    private Integer num;
//    逻辑外键，该订单项属于哪个订单
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private OrderEntity order;
}
