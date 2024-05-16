package com.ebook.repository;


//数据库操作


import com.ebook.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<BookEntity,Long> {
//    查找所有书籍
    @Query(value = "select * from tb_book order by id",nativeQuery = true)
    List<BookEntity>findAll();
//    根据关键词查找
    @Query(value = "select * from tb_book where title like %?1% ",nativeQuery = true)
    List<BookEntity> findByKeyword(String keyword);
}
