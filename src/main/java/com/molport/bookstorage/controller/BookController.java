package com.molport.bookstorage.controller;


import com.molport.bookstorage.domain.Author;
import com.molport.bookstorage.domain.Book;
import com.molport.bookstorage.service.AuthorService;
import com.molport.bookstorage.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    //Book
//SEARCH BOOK
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Book> books = bookService.search(keyword);
        ModelAndView modelAndView = new ModelAndView("search-results");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    //SHOW ALL BOOKS
    @RequestMapping("/listBooks")
    public ModelAndView listBooks() {
        List<Book> books = bookService.listAll();
        ModelAndView modelAndView = new ModelAndView("list-books");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    //ADD BOOK
    @RequestMapping("/addBook")
    public ModelAndView addBook(ModelAndView modelAndView) {
        System.out.println("ADDBOOK CONTROLLER");
        Book book = new Book();
        modelAndView.addObject("book", book);
        modelAndView.setViewName("new-book");
        return modelAndView;
    }

    //EDIT BOOK
    @RequestMapping("/editBook/{id}")
    public ModelAndView EditBook(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-book");
        Book book = bookService.get(id);
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    //DELETE BOOK
    @RequestMapping("/deleteBook/{id}")
    public ModelAndView deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return new ModelAndView("redirect:/book/listBooks");
    }

    //SAVE BOOK
    @RequestMapping("/saveBook")
    public ModelAndView saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return new ModelAndView("redirect:/book/listBooks");
    }

    //SAVE EDITED BOOK
    @RequestMapping("editBook/saveEditedBook")
    public ModelAndView saveEditedBook(@ModelAttribute Book book) {
        Book book1 = bookService.get(book.getId());
        book.setAuthors(book1.getAuthors());
        bookService.save(book);
        return new ModelAndView("redirect:/book/listBooks");
    }

//Author

    //SEARCH AUTHOR
    @RequestMapping("/searchByAuthor")
    public ModelAndView searchByAuthor(@RequestParam String keyword) {
        List<Author> authors = authorService.search(keyword);
        List<Book> books = new ArrayList<>();
        for (Author author1 : authors) {
            books.add(author1.getBook());
        }
        ModelAndView modelAndView = new ModelAndView("search-results");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    //ADD AUTHOR LIST
    @RequestMapping("/addAuthors/{id}")
    public ModelAndView addAuthor(@PathVariable("id") Long id) {
        Book book = bookService.get(id);
        ModelAndView modelAndView = new ModelAndView("add-author-book");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    //ADD AUTHOR
    @RequestMapping("addAuthors/addAuthorToBook/{id}")
    public ModelAndView addAuthorToBook(@PathVariable("id") Long bookId, @RequestParam("authorName") String authorName) {
        Book book = bookService.get(bookId);
        Author author = new Author(authorName, book);
        authorService.save(author);
        return new ModelAndView("redirect:/book/addAuthors/{id}");

    }

    //DELETE AUTHOR
    @RequestMapping("/addAuthors/deleteAuthor/{id}")
    public ModelAndView deleteAuthor(@PathVariable("id") Long id) {
        Author author = authorService.get(id);
        Book book = author.getBook();
        List<Author> bookauthors = book.getAuthors();
        bookauthors.remove(author);
        book.setAuthors(bookauthors);
        bookService.save(book);
        Long book_id = book.getId();

        return new ModelAndView("redirect:/book/addAuthors/" + book_id);
    }


//Remove all

    @RequestMapping("/flush")
    public String flush() {
        List<Book> books = bookService.listAll();
        for (Book book : books) {
            bookService.delete(book.getId());
        }
        return "redirect:/";
    }

}
