package com.ebook.service.impl;

import com.ebook.entity.OrderEntity;
import com.ebook.entity.OrderItem;
import com.ebook.repository.OrderRepository;
import com.ebook.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//实现接口类


@Service
public class OrderServiceimpl implements OrderService {
//    获取操作表的资格
    @Autowired
    OrderRepository orderRepository;

//    实现增加购物车
    @Override
    public OrderEntity addOrder(OrderEntity order){
        return orderRepository.save(order);
    }

//    获取用户购物车
    @Override
    public List<OrderEntity> getUserOrder(Long userid){
        return orderRepository.findByUserid(userid);
    }
}
