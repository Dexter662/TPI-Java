package com.informatorio.news.services.dto;

import com.informatorio.news.persitences.entity.ArticleStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleInDTO {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;
    private String author;
    private String source;
}
