package com.informatorio.news.mappers;

import com.informatorio.news.models.Author;
import com.informatorio.news.services.dto.AuthorInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AuthorInDTOToAuthor implements IMapper<AuthorInDTO, Author>{
    @Override
    public Author map(AuthorInDTO in) {
        Author author = new Author();
        author.setId(in.getId());
        author.setFirstname(in.getFirstname());
        author.setLastname(in.getLastname());
        author.setFullname(in.getFirstname() + " " + in.getLastname());
        author.setCreateAt(LocalDate.now());
        return author;
    }
}
