package com.informatorio.news.services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleInDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;
    private String author;
    private String source;
}
