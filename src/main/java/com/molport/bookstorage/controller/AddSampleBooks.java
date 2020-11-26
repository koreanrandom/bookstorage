package com.molport.bookstorage.controller;

import com.molport.bookstorage.domain.Author;
import com.molport.bookstorage.domain.Book;
import com.molport.bookstorage.service.AuthorService;
import com.molport.bookstorage.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddSampleBooks {

    private BookService bookService;
    private AuthorService authorService;


    public AddSampleBooks(BookService bookService, AuthorService authorService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    //ADD TEST BOOKS
    @RequestMapping("book/addTestBooks")
    public String showBooks() {
        System.out.println("TEST BOOKS ADDED");
        Book book = new Book("Java Programming 24-Hour Trainer", "2011", "Wrox");
        Book result = bookService.save(book);
        Author author = new Author("Yakov Fain", result);
        authorService.save(author);

        Book book2 = new Book("The Sleep Solution: Why Your Sleep is Broken and How to Fix It ", "2018", "Berkley");
        Book result2 = bookService.save(book2);
        Author author2 = new Author("W. Chris Winter", result2);
        authorService.save(author2);

        Book book3 = new Book("Data Structures and Algorithms in Java 2nd Edition", "2002", "Sams Publishing");
        Book result3 = bookService.save(book3);
        Author author3 = new Author("Robert Lafore", result3);
        authorService.save(author3);

        Book book4 = new Book("The No-Cry Sleep Solution, Second Edition", "2020", "McGraw-Hill Education");
        Book result4 = bookService.save(book4);
        Author author4 = new Author("Elizabeth Pantley", result4);
        authorService.save(author4);

        Book book5 = new Book("1001 Ridiculous Ways to Die", "2008", "Prion Books Ltd");
        Book result5 = bookService.save(book5);
        Author author5 = new Author("David Southwell", result5);
        authorService.save(author5);

        return "redirect:/book/listBooks";
    }
}
