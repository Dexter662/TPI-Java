package com.informatorio.news.repositories;

import com.informatorio.news.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SourceRepository extends JpaRepository<Source, Long> {

    @Query("SELECT s FROM Source s WHERE s.name LIKE %?1%")
    public List<Source> findAllSourceByWord(String word);
}
