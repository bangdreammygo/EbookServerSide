package com.ebook.dto;

//一个book类


public class BookJavaBean {
    ///////////////私有字段区域
    //书籍id
    private int id;
    //书名
    private String name;
    //库存
    private int rest;
    //售价
    private double price;
    //作者
    private String author;
    //简介
    private String brief;
    //目前还没有，但是之后会有的书籍图片
    //private String cover;




    //////////////////////构造函数
    //有参构造
    public BookJavaBean(int id, String name, int rest, double price, String author, String brief){
        this.id = id;
        this.name = name;
        this.rest = rest;
        this.price = price;
        this.author = author;
        this.brief = brief;
    }
    //无参构造函数
    public BookJavaBean(){

    }
    //只需要名字的情况
    public BookJavaBean(String name){
        this.name = name;
    }
    //////////////////////setter
    public  void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setRest(int rest){
        this.rest=rest;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setBrief(String brief) {
        this.brief = brief;
    }
    /////////////////////getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getRest() {
        return rest;
    }
    public double getPrice() {
        return price;
    }
    public String getAuthor() {
        return author;
    }
    public String getBrief() {
        return brief;
    }
}
