package com.valentyn.bdd.steps;

import com.valentyn.bom.Book;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GivenTest extends SpringIntegrationTest {

    @Given("the following books exist")
    public void theFollowingBooksExist(List<Book> books) {
//        log.info("bookConverter: {}", bookConverter);
//        log.info("bookService: {}", bookService);
//        Book bookTest = Book.builder().id(0L).title("TestBook").build();
//        bookService.saveBook(bookTest);
        for (Book book : books) {
            log.info("Book: {}", book);
        }
    }
}
