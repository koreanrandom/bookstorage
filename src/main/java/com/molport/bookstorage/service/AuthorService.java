package com.molport.bookstorage.service;

import java.util.List;

import com.molport.bookstorage.domain.Author;
import com.molport.bookstorage.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {
    @Autowired
    AuthorRepository repository;

    public void save(Author author) {
        repository.save(author);
    }

    public List<Author> search(String keyword) {
        return repository.search(keyword);
    }

    public List<Author> listAll() {
        return (List<Author>) repository.findAll();
    }

    public Author get(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}