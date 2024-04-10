package com.valentyn.bdd.steps;

import com.valentyn.bdd.common.TestContext;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class WhenTest extends SpringIntegrationTest {

    @When("Search the book by authors {string}")
    public void searchBookByAuthors(String author) {
        ResponseEntity<String> response = getRestTemplate().getForEntity(getUrl("/books/byAuthor?authorName={author}"), String.class, author);
        TestContext.getInstance().setResponse(response);
    }
}
