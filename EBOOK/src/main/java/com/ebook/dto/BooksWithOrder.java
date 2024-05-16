package com.ebook.dto;


//辅助类，负责前后端间信息传递的格式要求

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksWithOrder {
//    订单买了哪些书,每本书各有几本
    private List<BooksWithNum>books;
//    订单号
    private Long orderid;
//    收件人
    private String receiver;
//    联系电话
    private String phone;
//    收货地址
    private String address;
//    下单日期
    private LocalDateTime orderdate;
}
