package com.valentyn.bdd.steps;

import com.valentyn.bdd.common.TestContext;
import com.valentyn.bom.Book;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class WhenTest extends SpringIntegrationTest {

    @When("Search the book by authors {string}")
    public void searchBookByAuthors(String author) {
        ResponseEntity<Book[]> response = getRestTemplate().getForEntity(getUrl("/books/byAuthor?authorName={author}"), Book[].class, author);
        TestContext.getInstance().setResponse(response);
    }
}
