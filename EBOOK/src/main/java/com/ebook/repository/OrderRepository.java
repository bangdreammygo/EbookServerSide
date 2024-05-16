package com.ebook.repository;



//管理订单的接口
import com.ebook.entity.OrderEntity;
import com.ebook.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    //获取用户的所有订单信息
    public List<OrderEntity> findByUserid(Long userid);
}
