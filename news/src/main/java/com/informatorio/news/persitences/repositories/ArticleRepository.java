package com.informatorio.news.persitences.repositories;

import com.informatorio.news.persitences.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
