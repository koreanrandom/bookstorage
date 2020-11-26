package com.molport.bookstorage.domain;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Author() {
    }


    public Author(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String authorName) {
        this.name = authorName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    public Long getBookId() {
        return book.getId();
    }

}
