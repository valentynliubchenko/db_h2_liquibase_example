package com.valentyn.bdd;

import com.valentyn.bdd.common.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CucumberHooks {

    @Before
    public void init() {
        log.info("Run CucumberHooks Before init");
    }
    @After
    public void tearDown() {
        TestContext.dropInstance();
        log.info("tearDown completed...");
    }

    @ParameterType(".*")
    public List<Integer> intList(String value) {
        return Arrays.stream(value.split(",")).map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList());
    }

    @ParameterType(".*")
    public List<String> stringList(String value) {
        return Arrays.stream(value.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
