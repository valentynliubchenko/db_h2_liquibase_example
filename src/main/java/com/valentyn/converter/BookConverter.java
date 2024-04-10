package com.valentyn.converter;

import com.valentyn.bom.Book;
import com.valentyn.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookConverter {

    private final AuthorConverter authorConverter;

    public Book fromDTO(BookDTO bookDTO) {
        Book book = Book.builder().id(bookDTO.getId()).title(bookDTO.getTitle()).build();;
        if (bookDTO.getAuthor() != null) {
            book.setAuthor(authorConverter.fromDTO(bookDTO.getAuthor()));
        }
        return book;
    }

    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        if (book.getAuthor() != null) {
            bookDTO.setAuthor(authorConverter.toDTO(book.getAuthor()));
        }
        return bookDTO;
    }
}