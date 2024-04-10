package com.valentyn.bdd;

import com.valentyn.bdd.common.TestContext;
import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class CucumberSpringConfiguration {

    @After
    public void tearDown() {
        TestContext.dropInstance();
        log.info("tearDown completed...");
    }

}
