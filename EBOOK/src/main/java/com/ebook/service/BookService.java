package com.ebook.service;

import com.ebook.entity.BookEntity;

import java.util.List;

public interface BookService {
//    增
    public BookEntity insertBook(BookEntity book);
//    改
    public BookEntity updateBook(BookEntity book);
//    查
    public BookEntity findBookById(Long id);
//    返回数据库中所有的书籍
    public List<BookEntity> findAllBooks();
//    根据关键词搜索
    public List<BookEntity> SearchBooks(String keyword);
}
