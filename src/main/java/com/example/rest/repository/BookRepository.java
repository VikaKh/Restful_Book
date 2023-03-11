package com.example.rest.repository;

import com.example.rest.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByPublicationDate(LocalDate date);

    List<Book> findByTitleContaining(String title);
}