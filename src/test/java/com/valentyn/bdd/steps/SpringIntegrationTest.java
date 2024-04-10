package com.valentyn.bdd.steps;

import com.valentyn.bdd.common.TestContext;
import com.valentyn.converter.BookConverter;
import com.valentyn.service.BookService;
import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@Getter
@Setter
public class SpringIntegrationTest {

    @Autowired
    protected BookConverter bookConverter;

    @Autowired
    @SpyBean
    protected BookService bookService;

    protected final TestContext testContext = TestContext.getInstance();

}
