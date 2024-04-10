package com.valentyn.bdd.common;

import com.valentyn.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TestContext {

    private static final ThreadLocal<TestContext> testContext = new ThreadLocal<>();

    private Map<Long, BookDTO> bookDtoMap = new HashMap<>();

    private ResponseEntity response;

    public static TestContext getInstance() {
        if (testContext.get() == null) {
            testContext.set(new TestContext());
        }
        return testContext.get();
    }

    public static void dropInstance() {
        testContext.set(null);
    }

}
