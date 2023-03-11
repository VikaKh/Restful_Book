package com.example.rest.controller;

import com.example.rest.entity.Book;
import com.example.rest.exception.BookNotFoundException;
import com.example.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController//чтобы методы возвращали json,  Если хотим картинку то пишем аннотацию @Controller
@RequestMapping("/books") // ендпоинт над классом - главная над всеми методами, то есть пути будут прописываться вместе с ним
public class BookController {
    private BookService bookService;

    @Autowired // операция инжектим
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value="/all") // когда хотим получить == отобразить даннные
    List<Book> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping(value="/{id}")
    ResponseEntity<Book> getById(@PathVariable("id") Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(()->new BookNotFoundException("No Book with ID : "+id));
        return ResponseEntity.ok().body(book);
    }

    @GetMapping(value="/{title}")
    List<Book> getByTitle(@PathVariable("title") String title) {
        return bookService.findByTitle(title);
    }

    @PostMapping("/date") //
    public List<Book> getByLocalDate(@RequestParam("date") LocalDate date) {
        return bookService.findByPublicationDate(date);
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        return bookService.add(book);
    }

    @PutMapping("/put")
    public Book putBookById (@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
   public void deleteBookById (@PathVariable("id") Long id){
        bookService.delete(id);
    }
}

