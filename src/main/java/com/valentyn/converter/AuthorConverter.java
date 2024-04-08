package com.valentyn.converter;

import com.valentyn.bom.Author;
import com.valentyn.dto.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public Author fromDTO(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        return author;
    }

    public AuthorDTO toDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        return authorDTO;
    }
}

