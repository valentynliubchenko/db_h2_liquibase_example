package com.valentyn.bdd.steps;

import com.valentyn.service.BookService;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.*;

@Slf4j
public class ThenTest extends SpringIntegrationTest{

    @Then("I should find an author {string}")
    public void iShouldFindAnAuthor(String arg0) {
      log.info("iShouldFindAnAuthor");
      verify(bookService, times(1)).saveBook(any());
    }

}
