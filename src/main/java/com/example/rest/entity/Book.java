package com.example.rest.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name="publication_date")
    private LocalDate publicationDate;

    public Book() {
    }

    public Book(String title, LocalDate publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}