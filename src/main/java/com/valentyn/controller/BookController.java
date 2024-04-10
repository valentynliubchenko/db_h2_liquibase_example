package com.valentyn.controller;

import com.valentyn.bom.Author;
import com.valentyn.bom.Book;
import com.valentyn.service.BookService;
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
    public ResponseEntity<Book> createBook(@RequestParam String title, @RequestParam String authorName) {

        Book book = Book.builder().id(0L).title(title).build();;
        book.setTitle(title);

        Author author = new Author();
        author.setName(authorName);

        book.setAuthor(author);
        Book createdBook = bookService.saveBook(book);
        log.info("createdBook {}", createdBook);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/byAuthor")
    public List<Book> findByAuthorName(@RequestParam String authorName) {
        return bookService.findByAuthorName(authorName);
    }

    @GetMapping("/byAuthorName")
    public List<Book> findByAuthorFirstNameStartingWithAndAuthorLastNameEndingWith(
            @RequestParam String firstLetter,
            @RequestParam String lastLetter) {
        return bookService.findBooksByAuthorNameFirstAndLastLetter(firstLetter, lastLetter);
    }

}