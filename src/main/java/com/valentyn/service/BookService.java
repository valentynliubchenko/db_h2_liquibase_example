package com.valentyn.service;

import com.valentyn.dto.BookDTO;
import com.valentyn.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        return bookRepository.save(bookDTO);
    }

    public List<BookDTO> findByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }
    public List<BookDTO> findBooksByAuthorNameFirstAndLastLetter(String firstLetter, String lastLetter) {
        return bookRepository.findBooksByAuthorNameFirstAndLastLetter(firstLetter, lastLetter);
    }

}