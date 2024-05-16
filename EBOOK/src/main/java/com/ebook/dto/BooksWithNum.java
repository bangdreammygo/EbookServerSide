package com.ebook.dto;


import com.ebook.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksWithNum {
    private BookEntity book;
    private int num;
}
