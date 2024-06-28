package com.javatpoint.services;

import com.javatpoint.model.Book;
import com.javatpoint.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        var books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book getBookById(UUID bookid) {
        return bookRepository.findById(bookid).get();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        var existingBook = bookRepository.findById(book.getBookId());
        if(existingBook.isPresent())
            return bookRepository.save(book);
        return null;
    }

    public void deleteBook(UUID bookid) {
        var book = bookRepository.findById(bookid);
        if(book.isPresent())
            bookRepository.deleteById(bookid);
        return;
    }
}
