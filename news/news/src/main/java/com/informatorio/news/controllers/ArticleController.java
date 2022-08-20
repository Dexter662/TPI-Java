package com.informatorio.news.controllers;

import com.informatorio.news.models.Article;
import com.informatorio.news.models.ArticleStatus;
import com.informatorio.news.services.ArticleService;
import com.informatorio.news.services.dto.ArticleInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Article> findAllByStatus(@PathVariable("status") ArticleStatus status) {
        return this.articleService.findAllByArticleStatus(status);
    }

    @PatchMapping("/mark_as_published/{id}")
    public ResponseEntity<Void> markAsPublished(@PathVariable("id") Long id) {
        this.articleService.updateArticleAsPublished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        this.articleService.deleteArticleById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> updateArticle(@RequestBody ArticleInDTO articleInDTO) {
        this.articleService.updateArticle(articleInDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{word}")
    public List<Article> search(@PathVariable("word") String word){
        return this.articleService.findAllArticleByWord(word);
    }
}
