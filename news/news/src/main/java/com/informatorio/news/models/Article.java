package com.informatorio.news.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String url;
    private String urlToImage;
    @Column(nullable = false)
    private LocalDate publishedAt;
    @Column(length = 4000)
    private String content;
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable=false)
    private Author author;
    @ManyToOne(optional = false)
    @JoinColumn(name = "source_id", nullable=false)
    private Source source;
    private ArticleStatus articleStatus;

    public Article() {
    }

    public Article(Long id, String title, String description, String url, String urlToImage, LocalDate publishedAt, String content, Author author, Source source, ArticleStatus articleStatus) {
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

    public Article(String title, String description, String url, String urlToImage, LocalDate publishedAt, String content, Author author, Source source, ArticleStatus articleStatus) {
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
