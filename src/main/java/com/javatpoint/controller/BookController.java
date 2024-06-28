package com.javatpoint.controller;
import com.javatpoint.model.Book;
import com.javatpoint.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    private List<Book> getAllBooks(){
        var lesBooks = bookService.getAllBooks();
        return new ResponseEntity<>(lesBooks, HttpStatus.OK).getBody();
    }

    @GetMapping("/book/{bookid}")
    private Book getBookById(@PathVariable("bookid") UUID bookid){
        var book = bookService.getBookById(bookid);
        return new ResponseEntity<>(book, HttpStatus.OK).getBody();
    }

    @PostMapping("/createBook")
    private Book createBook(@RequestBody Book book){
        var leBook = bookService.createBook(book);
        return new ResponseEntity<>(leBook, HttpStatus.CREATED).getBody();
    }

    @PutMapping("/updateBook")
    private Book updateBook(@RequestBody Book book){
        var updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK).getBody();
    }

    @DeleteMapping("/deleteBook/{bookid}")
    private void deleteBook(@PathVariable("bookid") UUID bookid){
        bookService.deleteBook(bookid);
    }















}
