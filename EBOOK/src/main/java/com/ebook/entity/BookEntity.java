package com.ebook.entity;

//书籍的实体类

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_book")
@EntityListeners(AuditingEntityListener.class)
public class BookEntity {
    //书籍的主键id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //书籍的名字
    @Column(name = "title")
    private String title;
    //书籍的封面图片路径
    @Column(name = "cover")
    private String cover;
    //书籍的价格
    @Column(name = "price")
    private Long price;
    //书籍的库存剩余
    @Column(name = "rest")
    private int rest;
    //书籍的作者信息
    @Column(name = "author")
    private String author;
    //书籍的简介
    @Column(name = "brief")
    private String brief;
    //书籍的ISBN号
    @Column(name = "ISBN")
    private String ISBN;
}
