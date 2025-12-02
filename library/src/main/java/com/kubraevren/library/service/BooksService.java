package com.kubraevren.library.service;

import com.kubraevren.library.model.BookEntity;
import com.kubraevren.library.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BookEntity addBooks(BookEntity book) {
       return booksRepository.save(book);
    }
}
