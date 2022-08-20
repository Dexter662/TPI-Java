package com.informatorio.news.services.dto;

import com.informatorio.news.models.Author;
import com.informatorio.news.models.Source;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ArticleInDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDate publishedAt;
    private String content;
    private Author author;
    private Source source;
}
