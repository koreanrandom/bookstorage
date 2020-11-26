package com.molport.bookstorage.repository;

import com.molport.bookstorage.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long > {

    @Query(value = "SELECT b FROM Book b WHERE b.title LIKE '%' || :keyword || '%'" +
            "OR b.year LIKE '%' || :keyword || '%'" + "OR b.publisher LIKE '%' || :keyword || '%'")
    public List<Book> search(@Param("keyword") String keyword);

}


