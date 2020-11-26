package com.molport.bookstorage.service;

import com.molport.bookstorage.repository.BookRepository;
import com.molport.bookstorage.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository repository;

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> listAll() {
        return (List<Book>) repository.findAll();
    }

    public List<Book> search(String keyword) {
        return repository.search(keyword);
    }

    public Book get(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}


