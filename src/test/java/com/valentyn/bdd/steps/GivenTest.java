package com.valentyn.bdd.steps;

import com.valentyn.bom.Author;
import com.valentyn.bom.Book;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GivenTest extends SpringIntegrationTest {

    @Given("the following books exist")
    public void theFollowingBooksExist(List<Book> books) {
        log.info("bookConverter: {}", bookConverter);
        log.info("bookService: {}", bookService);
        Author authorTest = new Author();
        authorTest.setId(0L);
        authorTest.setName("TestAuthor");
        Book bookTest = Book.builder().id(0L).title("TestBook").author(authorTest).build();
        log.info("bookTest: {}", bookTest);

        bookService.saveBook(bookTest);
        for (Book book : books) {
            log.info("Book: {}", book);
        }
    }
}
