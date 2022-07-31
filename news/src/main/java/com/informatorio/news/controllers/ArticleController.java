package com.informatorio.news.controllers;

import com.informatorio.news.persitences.entity.Article;
import com.informatorio.news.services.ArticleService;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public Article createArticle(@RequestBody ArticleInDTO articleInDTO) {
        return  this.articleService.createArticle(articleInDTO);
    }
}
