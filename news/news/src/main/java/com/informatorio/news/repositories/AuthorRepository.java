package com.informatorio.news.repositories;

import com.informatorio.news.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.fullname LIKE %?1%")
    public List<Author> findAllAuthorByWord(String word);
}
