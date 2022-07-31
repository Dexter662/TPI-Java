package com.informatorio.news.controllers;

import com.informatorio.news.persitences.entity.Article;
import com.informatorio.news.persitences.entity.ArticleStatus;
import com.informatorio.news.services.ArticleService;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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

    @GetMapping
    public List<Article> findAll(){
        return this.articleService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Article> findAllByStatus(@PathVariable("status")ArticleStatus status) {
        return this.articleService.findAllByArticleStatus(status);
    }

    @PatchMapping("/mark_as_published/{id}")
    public ResponseEntity<Void> markAsPublished(@PathVariable("id") Long id) {
        this.articleService.updateArticleAsPublished(id);
        return ResponseEntity.noContent().build();
    }
}
