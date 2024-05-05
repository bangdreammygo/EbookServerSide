package com.ebook.Controller;


//用来获取订单的后端接口


import com.ebook.dto.BookJavaBean;
import com.ebook.dto.CartJavaBean;
import com.ebook.dto.OrderJavaBean;
import com.ebook.pojo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class OrderController {


    @RequestMapping("/order/get")
    public ArrayList<OrderJavaBean> getOrder(int id) {
    //通过用户的id获取到该id下的所有订单信息
        ArrayList<OrderJavaBean> orders = new ArrayList<OrderJavaBean>();
        OrderJavaBean order = new OrderJavaBean();
        order.setId(114);
        order.setDate((LocalDate.now()).toString());
        order.setAddress("羽丘");
        order.setPhone("1145141999");
        order.setReceiver("丰川祥子");
        CartJavaBean[]arr={new CartJavaBean(),new CartJavaBean()};
        arr[0].setBook(new BookJavaBean("哑舍零·秦失其鹿"));
        arr[0].setNum(3);
        arr[1].setBook(new BookJavaBean("浮生物语五"));
        arr[1].setNum(4);
        order.setProducts(arr);
        orders.add(
                order
        );

        return orders;
    }
}
