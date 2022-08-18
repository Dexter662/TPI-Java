package com.informatorio.news.services;

import com.informatorio.news.exceptions.ToDoExceptions;
import com.informatorio.news.mappers.ArticleInDTOToArticle;
import com.informatorio.news.models.Article;
import com.informatorio.news.models.ArticleStatus;
import com.informatorio.news.repositories.ArticleRepository;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ToDoExceptions("Article not found", HttpStatus.NOT_FOUND);
        }
        this.articleRepository.markArticleAsPublished(id);
    }

    public void deleteArticleById(Long id) {
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ToDoExceptions("Article not found", HttpStatus.NOT_FOUND);
        }
        this.articleRepository.deleteById(id);
    }

    public Article updateArticle(ArticleInDTO articleInDTO) {
        Optional<Article> optionalArticle = this.articleRepository.findById(articleInDTO.getId());
        if (optionalArticle.isEmpty()) {
            throw new ToDoExceptions("Article not found", HttpStatus.NOT_FOUND);
        }
        Article article =  articleInDTOToArticle.map(articleInDTO);
        return this.articleRepository.saveAndFlush(article);
    }
}
