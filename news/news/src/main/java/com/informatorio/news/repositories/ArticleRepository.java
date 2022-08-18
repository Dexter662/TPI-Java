package com.informatorio.news.repositories;

import com.informatorio.news.models.Article;
import com.informatorio.news.models.ArticleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    public List<Article> findAllByArticleStatus(ArticleStatus status);

    @Modifying
    @Query(value = "UPDATE `article` SET `article_status`= 0 WHERE id=:id", nativeQuery = true)
    public void markArticleAsPublished(@Param("id") Long id);
}
