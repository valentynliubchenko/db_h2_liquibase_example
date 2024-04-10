package com.valentyn.bdd.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valentyn.converter.BookConverter;
import com.valentyn.repository.BookRepository;
import com.valentyn.service.BookService;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Slf4j
@Getter
@Setter
public class SpringIntegrationTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected BookConverter bookConverter;

    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    @SpyBean
    protected BookService bookService;

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    protected String getUrl(String uri) {
        String result = "http://127.0.0.1:" + port + uri;
        log.debug("Final URL is " + result);
        return result;
    }


}
