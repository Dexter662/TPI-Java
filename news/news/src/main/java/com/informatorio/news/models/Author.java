package com.informatorio.news.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String fullname;
    private LocalDate createAt;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Article> article = new HashSet<>();

    public Author() {
    }

    public Author(Long id, String firstname, String lastname, String fullname, LocalDate createAt, Set<Article> article) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.createAt = createAt;
        this.article = article;
    }

    public Author(String firstname, String lastname, String fullname, LocalDate createAt, Set<Article> article) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.createAt = createAt;
        this.article = article;
    }
}
