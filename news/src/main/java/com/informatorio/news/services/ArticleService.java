package com.informatorio.news.services;

import com.informatorio.news.mapper.ArticleInDTOToArticle;
import com.informatorio.news.persitences.entity.Article;
import com.informatorio.news.persitences.repositories.ArticleRepository;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.stereotype.Service;

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
}
