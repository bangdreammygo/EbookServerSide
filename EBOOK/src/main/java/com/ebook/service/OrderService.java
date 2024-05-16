package com.ebook.service;

//订单的相关服务

import com.ebook.entity.OrderEntity;
import com.ebook.entity.OrderItem;

import java.util.List;

public interface OrderService {
//    增
    public OrderEntity addOrder(OrderEntity order);

//   获取用户订单
    public List<OrderEntity> getUserOrder(Long userid);
}
