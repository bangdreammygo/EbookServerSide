package com.ebook.entity;

//映射order


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class OrderEntity {

//    订单号
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    下单者
    @Column(name = "userid")
    private Long userid;

//    收件人
    @Column(name = "receiver")
    private String receiver;

//    联系电话
    @Column(name = "phone")
    private String phone;

//    收件地址
    @Column(name = "address")
    private String address;

//    下单时间
    @Column(name = "orderdate")
    private LocalDateTime orderdate;

//    外键，一对多，订单项
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    List<OrderItem>orderitems;
}
