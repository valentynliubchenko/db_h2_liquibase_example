package com.valentyn.bdd.steps;

import com.valentyn.bdd.common.TestContext;
import com.valentyn.bom.Book;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class ThenTest extends SpringIntegrationTest {

    @Then("Book will find")
    public void bookWillFind(List<Book> expectedBooks) {
        List<Book> actualBooks = List.of((Book[]) TestContext.getInstance().getResponse().getBody());
        log.info("body: {}", actualBooks);
        Long expectedBookID = TestContext.getInstance().getBookDtoMap().get(expectedBooks.get(0).getId()).getId();
        assertEquals(expectedBooks.get(0).getTitle(), actualBooks.get(0).getTitle());
        assertEquals(expectedBooks.get(0).getAuthor().getName(), actualBooks.get(0).getAuthor().getName());
        assertEquals(expectedBookID, actualBooks.get(0).getId());
    }

    @Then("Request returned code {int}")
    public void requestReturnedCode(int errorCode) {
        assertEquals(errorCode, TestContext.getInstance().getResponse().getStatusCode().value());
    }

    @And("Book will be created")
    public void bookWillBeCreated(List<Book> expectedBooks) {
        Book actualBooks = (Book) TestContext.getInstance().getResponse().getBody();
        log.info("bookWillBeCreated: actualBooks {}", actualBooks);
        assertNotNull(actualBooks);
        assertEquals(expectedBooks.get(0).getTitle(), actualBooks.getTitle());
        assertEquals(expectedBooks.get(0).getAuthor().getName(), actualBooks.getAuthor().getName());
    }
}
