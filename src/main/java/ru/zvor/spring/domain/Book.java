package ru.zvor.spring.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Data
public class Book {
    private final long id;
    private final String name;
    private final long author;
}
