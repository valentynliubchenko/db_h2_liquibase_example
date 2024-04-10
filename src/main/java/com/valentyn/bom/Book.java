package com.valentyn.bom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private Long id;

    private String title;

    private Author author;

}