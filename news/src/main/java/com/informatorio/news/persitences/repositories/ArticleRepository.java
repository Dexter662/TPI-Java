package com.informatorio.news.persitences.repositories;

import com.informatorio.news.persitences.entity.Article;
import com.informatorio.news.persitences.entity.ArticleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    public List<Article> findAllByArticleStatus(ArticleStatus status);

    @Modifying
    @Query(value = "UPDATE `article` SET `article_status`= 1 WHERE id=:id", nativeQuery = true)
    public void markArticleAsPublished(@Param("id") Long id);
}
