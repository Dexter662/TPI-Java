package com.informatorio.news.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;
    private String author;
    private String source;
    private ArticleStatus articleStatus;

    public Article() {
    }

    public Article(Long id, String title, String description, String url, String urlToImage, LocalDateTime publishedAt, String content, String author, String source, ArticleStatus articleStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.author = author;
        this.source = source;
        this.articleStatus = articleStatus;
    }

    public Article(String title, String description, String url, String urlToImage, LocalDateTime publishedAt, String content, String author, String source, ArticleStatus articleStatus) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.author = author;
        this.source = source;
        this.articleStatus = articleStatus;
    }
}
