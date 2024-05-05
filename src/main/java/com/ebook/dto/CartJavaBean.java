package com.ebook.dto;

//封装cart的javabean


///购物车项：一个购物车是由里面的多个购物车项一起组成的
public class CartJavaBean {
     //这个购物车项对应的用户id（谁的购物车里的）
     private int id;
     //这项是哪本书
     private BookJavaBean book;
     //几本书
     private int num;




     public CartJavaBean() {

     }
     public CartJavaBean(int id, BookJavaBean book, int num) {
         this.id = id;
         this.book = book;
         this.num = num;
     }
     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
     public BookJavaBean getBook() {
         return book;
     }
     public void setBook(BookJavaBean book) {
         this.book = book;
     }
     public int getNum() {
         return num;
     }
     public void setNum(int num) {
         this.num = num;
     }
}
