package com.ebook.service.impl;

import com.ebook.entity.BookEntity;
import com.ebook.repository.BookRepository;
import com.ebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
//  增加新书
    @Override
    public BookEntity insertBook(BookEntity book){
        return bookRepository.save(book);
    }

//   更新书籍
    @Override
   public BookEntity updateBook(BookEntity book){
        return bookRepository.save(book);
   }
//根据id查询书籍
    @Override
    public BookEntity findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
//    获取所有书籍
    @Override
    public List<BookEntity> findAllBooks(){
        return bookRepository.findAll();
    }
//    模糊搜索
    @Override
    public List<BookEntity> SearchBooks(String keyword){
        return bookRepository.findByKeyword(keyword);
    }
}
