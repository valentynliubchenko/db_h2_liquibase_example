package com.valentyn.converter;

import com.valentyn.bom.Author;
import com.valentyn.dto.AuthorDTO;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
public class AuthorConverterTest {

    private final AuthorConverter authorConverter = new AuthorConverter();

    @Test
    public void testFromDTO() {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("Test Author");

        Author author = authorConverter.fromDTO(authorDTO);

        Assertions.assertNotNull(author);
        Assertions.assertEquals(authorDTO.getId(), author.getId());
        Assertions.assertEquals(authorDTO.getName(), author.getName());
    }

    @Test
    public void testToDTO() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");

        AuthorDTO authorDTO = authorConverter.toDTO(author);

        Assertions.assertNotNull(authorDTO);
        Assertions.assertEquals(author.getId(), authorDTO.getId());
        Assertions.assertEquals(author.getName(), authorDTO.getName());
    }
}