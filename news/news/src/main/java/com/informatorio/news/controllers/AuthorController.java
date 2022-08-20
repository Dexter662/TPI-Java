package com.informatorio.news.controllers;

import com.informatorio.news.models.Author;
import com.informatorio.news.services.AuthorService;
import com.informatorio.news.services.dto.AuthorInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author createAuthor(@Valid @RequestBody AuthorInDTO authorInDTO) {
        return  this.authorService.createAuthor(authorInDTO);
    }

    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long id) {
        this.authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable("id") Long id, @Valid @RequestBody AuthorInDTO authorInDTO) {
        this.authorService.updateAuthor(id, authorInDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{word}")
    public List<Author> search(@PathVariable("word") String word){
        return this.authorService.findAllAuthorByWord(word);
    }
}
