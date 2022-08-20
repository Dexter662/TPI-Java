package com.informatorio.news.services;

import com.informatorio.news.exceptions.ToDoExceptions;
import com.informatorio.news.mappers.AuthorInDTOToAuthor;
import com.informatorio.news.models.Author;
import com.informatorio.news.repositories.AuthorRepository;
import com.informatorio.news.services.dto.AuthorInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorInDTOToAuthor authorInDTOToAuthor;

    public AuthorService(AuthorRepository authorRepository, AuthorInDTOToAuthor authorInDTOToAuthor) {
        this.authorRepository = authorRepository;
        this.authorInDTOToAuthor = authorInDTOToAuthor;
    }

    public Author createAuthor(AuthorInDTO authorInDTO) {
        Author author =  authorInDTOToAuthor.map(authorInDTO);
        return this.authorRepository.save(author);
    }

    public List<Author> findAll() {
        return (List<Author>) this.authorRepository.findAll();
    }

    public void deleteAuthorById(Long id) {
        Optional<Author> optionalAuthor = this.authorRepository.findById(id);
        if (optionalAuthor.isEmpty()) {
            throw new ToDoExceptions("Author not found", HttpStatus.NOT_FOUND);
        }
        this.authorRepository.deleteById(id);
    }

    public Author updateAuthor(Long id, AuthorInDTO authorInDTO) {
        Optional<Author> optionalAuthor = this.authorRepository.findById(id);
        if (optionalAuthor.isEmpty()) {
            throw new ToDoExceptions("Author not found", HttpStatus.NOT_FOUND);
        }
        authorInDTO.setId(optionalAuthor.get().getId());
        Author author =  authorInDTOToAuthor.map(authorInDTO);
        return this.authorRepository.saveAndFlush(author);
    }

    public List<Author> findAllAuthorByWord(String word){
        if (word.length() >= 3) {
            return authorRepository.findAllAuthorByWord(word);
        } else {
            throw new ToDoExceptions("You must enter at least 3 characters", HttpStatus.LENGTH_REQUIRED);
        }
    }
}
