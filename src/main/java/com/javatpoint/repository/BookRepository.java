package com.javatpoint.repository;

import com.javatpoint.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {
}
