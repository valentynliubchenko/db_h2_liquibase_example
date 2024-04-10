package com.valentyn.bdd.steps;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThenTest extends SpringIntegrationTest{
    @Then("I should find an author {string}")
    public void iShouldFindAnAuthor(String arg0) {
      log.info("iShouldFindAnAuthor");
    }

}
