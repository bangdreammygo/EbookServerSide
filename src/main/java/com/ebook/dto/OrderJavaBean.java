package com.ebook.dto;

//处理提交上来的订单

import java.time.LocalDate;

public class OrderJavaBean {
    //订单号
    private int id;
    //收获地址
    private String address;
    //联系方式
    private String phone;
    //收件人
    private String receiver;
    //商品信息
    private CartJavaBean[] products;
    //日期时间
    private String date;
    public OrderJavaBean() {

    }
    public OrderJavaBean(int id, String address, String phone, String receiver) {
        this.id = id;
        this.address = address;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public CartJavaBean[] getProducts() {
        return products;
    }
    public void setProducts(CartJavaBean[] products) {
        this.products = products;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
