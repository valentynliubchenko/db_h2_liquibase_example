package com.valentyn.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valentyn.bom.Author;
import com.valentyn.bom.Book;
import com.valentyn.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateBook() throws Exception {
        // Arrange
        String title = "Test Book";
        String authorName = "Test Author";
        Book book = Book.builder().id(0L).title(title).build();;
        Author author = new Author();
        author.setName(authorName);
        book.setAuthor(author);
        when(bookService.saveBook(any(Book.class))).thenReturn(book);

        // Act & Assert
        mockMvc.perform(post("/books/create")
                        .param("title", title)
                        .param("authorName", authorName))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.author.name").value(authorName));
        // Verify
        verify(bookService).saveBook(book);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        // Arrange
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().id(1L).title("title 1").build());
        books.add(Book.builder().id(2L).title("title 2").build());
        when(bookService.getAllBooks()).thenReturn(books);

        // Act
        MvcResult result = mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String content = result.getResponse().getContentAsString();
        List<Book> actualBooks = objectMapper.readValue(content, new TypeReference<>() {
        });

        // Assert
        Assertions.assertEquals(2, actualBooks.size());
        // Verify
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void testSaveBook() throws Exception {
        // Arrange
        Book book = Book.builder().id(0L).title("First Title").build();;
        when(bookService.saveBook(any(Book.class))).thenReturn(book);
        String requestBody = objectMapper.writeValueAsString(book);

        // Act & Assert
        MvcResult result = mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(requestBody))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Book actualBooks = objectMapper.readValue(content, Book.class);

        // Assert
        Assertions.assertEquals("First Title", actualBooks.getTitle());
        // Verify
        verify(bookService, times(1)).saveBook(book);
    }

    @Test
    public void testFindByAuthorName() throws Exception {
        // Arrange
        String authorName = "Test Author";
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().id(1L).title("title 1").build());
        books.add(Book.builder().id(2L).title("title 2").build());
        when(bookService.findByAuthorName(authorName)).thenReturn(books);

        // Act & Assert
        MvcResult result = mockMvc.perform(get("/books/byAuthor")
                        .param("authorName", authorName))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String content = result.getResponse().getContentAsString();
        List<Book> actualBooks = objectMapper.readValue(content, new TypeReference<>() {
        });

        // Assert
        Assertions.assertEquals(2, actualBooks.size());
        // Verify
        verify(bookService, times(1)).findByAuthorName(authorName);
    }

    @Test
    public void testFindByAuthorFirstNameStartingWithAndAuthorLastNameEndingWith() throws Exception {
        // Arrange
        String firstLetter = "A";
        String lastLetter = "Z";
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().id(1L).title("title 1").build());
        books.add(Book.builder().id(2L).title("title 2").build());
        when(bookService.findBooksByAuthorNameFirstAndLastLetter(firstLetter, lastLetter)).thenReturn(books);

        // Act & Assert
        MvcResult result = mockMvc.perform(get("/books/byAuthorName")
                        .param("firstLetter", firstLetter)
                        .param("lastLetter", lastLetter))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String content = result.getResponse().getContentAsString();
        List<Book> actualBooks = objectMapper.readValue(content, new TypeReference<>() {
        });

        // Assert
        Assertions.assertEquals(2, actualBooks.size());
        // Verify
        verify(bookService, times(1)).findBooksByAuthorNameFirstAndLastLetter(firstLetter, lastLetter);
    }
}