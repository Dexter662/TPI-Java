package com.informatorio.news.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "source")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String code;
    private LocalDate createAt;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private Set<Article> article = new HashSet<>();

    public Source() {
    }

    public Source(Long id, String name, String code, LocalDate createAt, Set<Article> article) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createAt = createAt;
        this.article = article;
    }

    public Source(String name, String code, LocalDate createAt, Set<Article> article) {
        this.name = name;
        this.code = code;
        this.createAt = createAt;
        this.article = article;
    }
}
