package com.valentyn.service;

import com.valentyn.bom.Book;
import com.valentyn.converter.BookConverter;
import com.valentyn.dto.BookDTO;
import com.valentyn.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private final BookRepository bookRepository = mock(BookRepository.class);

    private final BookConverter bookConverter = mock(BookConverter.class);

    private final BookService bookService = new BookService(bookRepository, bookConverter);

    @Test
    public void testGetAllBooks() {
        // Arrange
        List<BookDTO> bookDTOList = new ArrayList<>();
        BookDTO firstBookDTO = new BookDTO();
        bookDTOList.add(firstBookDTO);
        BookDTO secondBookDTO = new BookDTO();
        bookDTOList.add(secondBookDTO);
        when(bookRepository.findAll()).thenReturn(bookDTOList);
        Book book = new Book();
        when(bookConverter.fromDTO(any(BookDTO.class))).thenReturn(book);

        // Act
        List<Book> result = bookService.getAllBooks();

        // Assert
        assertEquals(bookDTOList.size(), result.size());
        verify(bookRepository, times(1)).findAll();
        verify(bookConverter, times(2)).fromDTO(any(BookDTO.class));

    }

    @Test
    public void testSaveBook() {
        // Arrange
        Book book = new Book();
        BookDTO bookDTO = new BookDTO();
        when(bookConverter.toDTO(book)).thenReturn(bookDTO);
        when(bookConverter.fromDTO(bookDTO)).thenReturn(book);
        when(bookRepository.save(bookDTO)).thenReturn(bookDTO);

        // Act
        Book result = bookService.saveBook(book);

        // Assert
        assertEquals(book, result);
        verify(bookConverter, times(1)).toDTO(book);
        verify(bookConverter, times(1)).fromDTO(bookDTO);
        verify(bookRepository, times(1)).save(bookDTO);
    }

}