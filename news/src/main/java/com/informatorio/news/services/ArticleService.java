package com.informatorio.news.services;

import com.informatorio.news.mapper.ArticleInDTOToArticle;
import com.informatorio.news.persitences.entity.Article;
import com.informatorio.news.persitences.entity.ArticleStatus;
import com.informatorio.news.persitences.repositories.ArticleRepository;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleInDTOToArticle articleInDTOToArticle;

    public ArticleService(ArticleRepository articleRepository, ArticleInDTOToArticle articleInDTOToArticle) {
        this.articleRepository = articleRepository;
        this.articleInDTOToArticle = articleInDTOToArticle;
    }

    public Article createArticle(ArticleInDTO articleInDTO) {
        Article article =  articleInDTOToArticle.map(articleInDTO);
        return this.articleRepository.save(article);
    }

    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    public List<Article> findAllByArticleStatus(ArticleStatus status) {
        return this.articleRepository.findAllByArticleStatus(status);
    }

    @Transactional
    public void updateArticleAsPublished(Long id) {
        this.articleRepository.markArticleAsPublished(id);
    }
}
