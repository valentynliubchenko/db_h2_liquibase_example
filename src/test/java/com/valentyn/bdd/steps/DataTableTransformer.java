package com.valentyn.bdd.steps;

import com.valentyn.bom.Author;
import com.valentyn.bom.Book;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public Book defineBook(Map<String, String> entryMap) {
        Book book = Book.builder().id(0L).build();
        if (entryMap.containsKey("BookId"))
            book.setId(stringIdToLong(entryMap.get("BookId")));
        Author author = new Author();
        author.setId(0L);
        if (entryMap.containsKey("Author"))
            author.setName(entryMap.get("Author"));
        if (entryMap.containsKey("Title"))
            book.setTitle(entryMap.get("Title"));
        book.setAuthor(author);
        return book;
    }

    private Long stringIdToLong(String id) {
        return Long.parseLong(id.replaceAll("\\*", ""));
    }

}
