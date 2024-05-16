package com.ebook.dto;


import com.ebook.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksWithPage {
    private List<BookEntity>allBooks;
    private int total;
}
