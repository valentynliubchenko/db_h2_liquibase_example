package com.valentyn.controller;

import com.valentyn.dto.AuthorDTO;
import com.valentyn.dto.BookDTO;
import com.valentyn.service.BookService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook(@RequestParam String title, @RequestParam String authorName) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(title);

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(authorName);

        bookDTO.setAuthor(authorDTO);

        BookDTO createdBook = bookService.saveBook(bookDTO);
        log.info("createdBook {}",createdBook);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookDTO saveBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }
}