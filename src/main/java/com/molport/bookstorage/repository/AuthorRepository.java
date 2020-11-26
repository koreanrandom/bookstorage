package com.molport.bookstorage.repository;


import com.molport.bookstorage.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long > {

    @Query(value = "SELECT a FROM Author a WHERE a.name LIKE '%' || :keyword || '%'")
    public List<Author> search(@Param("keyword") String keyword);
}
