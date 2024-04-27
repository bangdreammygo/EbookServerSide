package com.ebook.dto;

//一个book类


public class BookJavaBean {
    ///////////////私有字段区域
    private int id;
    private String name;
    private int num;
    private double price;
    private String author;
    private String brief;
    //////////////////////构造函数
    //有参构造
    public BookJavaBean(int id, String name, int num, double price, String author, String brief){
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
        this.author = author;
        this.brief = brief;
    }
    //无参构造函数
    public BookJavaBean(){

    }
    //////////////////////setter
    public  void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setNum(int num) {
        this.num = num;
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
    public int getNum() {
        return num;
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
