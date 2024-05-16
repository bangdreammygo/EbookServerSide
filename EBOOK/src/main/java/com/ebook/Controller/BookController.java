package com.ebook.Controller;


import com.ebook.entity.BookEntity;
import com.ebook.dto.BooksWithPage;
import com.ebook.pojo.Result;
import com.ebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//控制书籍信息的类
@RestController
@CrossOrigin
@Transactional
public class BookController {

    //获取书籍相关服务
    @Autowired
    private BookService bookService;



//      增加新书
    @RequestMapping("/book/add")
    public Result addBook(@RequestBody BookEntity bookEntity){
        BookEntity res=bookService.insertBook(bookEntity);
        return new Result(200,"success",res);
    }



//    获取指定页码的书籍
    @RequestMapping("/book/get")
    public Result getBook(int pageIndex, int pageSize ,String keyword){
        //如果是搜索而非获取全部
        if(keyword!=""){
            List<BookEntity>total=bookService.SearchBooks(keyword);
            //创建返回体
            List<BookEntity>res=new ArrayList<BookEntity>();
            //计算从第几本到第几本
            int num=(pageIndex-1)*pageSize;
            int totalnum=total.size();
            for(int i=0;i<pageSize&&(i+num)<totalnum;i++){
                res.add(total.get(num+i));
            }
            int totalPage=(totalnum)/pageSize+1;
            return new Result(200,"success",new BooksWithPage(res,totalPage));
        }
        //找到所有书
        List<BookEntity>booklist=bookService.findAllBooks();
        int total=bookService.findAllBooks().size();
        //创建返回体
        List<BookEntity>res=new ArrayList<BookEntity>();
        //计算从第几本到第几本
        int num=(pageIndex-1)*pageSize;
        for(int i=0;i<pageSize&&(i+num)<total;i++){
            res.add(booklist.get(num+i));
        }
        int totalPage=(total)/pageSize+1;
        return new Result(200,"success",new BooksWithPage(res,totalPage));
    }




//    通过id获取书籍
    @RequestMapping("book/detail")
    public Result getBookDetail(Long id){
        BookEntity book=bookService.findBookById(id);
        return new Result(200,"success",book);
    }

}
