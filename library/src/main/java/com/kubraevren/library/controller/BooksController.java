package com.kubraevren.library.controller;

import com.kubraevren.library.model.BookEntity;
import com.kubraevren.library.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RequestMapping("books")//http://localhost:8080/books
@RestController
public class BooksController {
    private final BooksService booksService;


    @PostMapping
    public BookEntity addBooks(@RequestBody BookEntity book){

        return booksService.addBooks(book);
    }
}
