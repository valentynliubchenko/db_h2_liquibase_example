package com.valentyn.bom;

import lombok.Data;

@Data
public class Book {

    private Long id;

    private String title;

    private Author author;

}