package com.informatorio.news.mappers;

import com.informatorio.news.models.Article;
import com.informatorio.news.models.ArticleStatus;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.stereotype.Component;

@Component
public class ArticleInDTOToArticle implements IMapper<ArticleInDTO, Article>{

    @Override
    public Article map(ArticleInDTO in) {
        Article article = new Article();
        article.setId(in.getId());
        article.setTitle(in.getTitle());
        article.setDescription(in.getDescription());
        article.setUrl(in.getUrl());
        article.setUrlToImage(in.getUrlToImage());
        article.setPublishedAt(in.getPublishedAt());
        if (in.getPublishedAt() == null){
            article.setArticleStatus(ArticleStatus.ERASER);
        } else {
            article.setArticleStatus(ArticleStatus.PUBLISHED);
        }
        article.setContent(in.getContent());
        article.setAuthor(in.getAuthor());
        article.setSource(in.getSource());
        return article;
    }
}
