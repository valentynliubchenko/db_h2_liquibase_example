package com.valentyn.bdd.steps;

import com.valentyn.bdd.common.TestContext;
import com.valentyn.bom.Book;
import com.valentyn.dto.BookDTO;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GivenTest extends SpringIntegrationTest {

    @Given("the following books exist")
    public void theFollowingBooksExist(List<Book> books) {
        log.info("theFollowingBooksExist: bookConverter: {}", bookConverter);
        log.info("theFollowingBooksExist: bookService: {}", bookService);
        for (Book book : books) {
            log.info("theFollowingBooksExist: Book: {}", book);
            BookDTO dto = bookConverter.toDTO(book);
            dto.setId(0L);
            BookDTO savedDto = bookRepository.save(dto);
            log.info("theFollowingBooksExist: Book: savedDto {} book.getId() {}", savedDto, book.getId());
            TestContext.getInstance().getBookDtoMap().put(book.getId(), savedDto);
        }
    }
}
