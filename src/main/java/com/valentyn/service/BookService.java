package com.valentyn.service;

import com.valentyn.bom.Book;
import com.valentyn.converter.BookConverter;
import com.valentyn.dto.BookDTO;
import com.valentyn.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    private final BookConverter bookConverter;

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        for (BookDTO bookDTO : bookRepository.findAll()) {
            bookList.add(bookConverter.fromDTO(bookDTO));
        }
        return bookList;
    }

    public Book saveBook(Book book) {
        BookDTO bookDTO = bookConverter.toDTO(book);
        return bookConverter.fromDTO(bookRepository.save(bookDTO));
    }

    public List<Book> findByAuthorName(String authorName) {
        List<Book> bookList = new ArrayList<>();
        for (BookDTO bookDTO : bookRepository.findByAuthorName(authorName)) {
            bookList.add(bookConverter.fromDTO(bookDTO));
        }
        return bookList;
    }

    public List<Book> findBooksByAuthorNameFirstAndLastLetter(String firstLetter, String lastLetter) {
        List<Book> bookList = new ArrayList<>();
        for (BookDTO bookDTO : bookRepository.findBooksByAuthorNameFirstAndLastLetter(firstLetter, lastLetter)) {
            bookList.add(bookConverter.fromDTO(bookDTO));
        }
        return bookList;
    }

}