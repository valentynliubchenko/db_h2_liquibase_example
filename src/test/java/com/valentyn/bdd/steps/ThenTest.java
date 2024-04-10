package com.valentyn.bdd.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.valentyn.bdd.common.TestContext;
import com.valentyn.bom.Book;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class ThenTest extends SpringIntegrationTest {

    @Then("Book will find")
    public void bookWillFind(List<Book> expectedBooks) throws JsonProcessingException {
        String body = TestContext.getInstance().getResponse().getBody().toString();
        log.info("body: {}", body);
        List<Book> actualBooks = objectMapper.readValue(body, new TypeReference<>() { });
        Long expectedBookID = TestContext.getInstance().getBookDtoMap().get(expectedBooks.get(0).getId()).getId();
        assertEquals(expectedBooks.get(0).getTitle(), actualBooks.get(0).getTitle());
        assertEquals(expectedBooks.get(0).getAuthor().getName(), actualBooks.get(0).getAuthor().getName());
        assertEquals(expectedBookID, actualBooks.get(0).getId());
    }

    @Then("Request returned code {int}")
    public void requestReturnedCode(int errorCode) {
        assertEquals(errorCode, TestContext.getInstance().getResponse().getStatusCode().value());
    }
}
