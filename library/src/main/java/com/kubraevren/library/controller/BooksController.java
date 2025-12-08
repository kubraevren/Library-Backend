package com.kubraevren.library.controller;

import com.kubraevren.library.dto.BookRequestDto;
import com.kubraevren.library.dto.BookResponseDto;
import com.kubraevren.library.mapper.BooksMapper;
import com.kubraevren.library.model.BookEntity;
import com.kubraevren.library.repository.BooksRepository;
import com.kubraevren.library.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("books")//http://localhost:8080/books
@RestController
public class BooksController {
    private final BooksService booksService;
private final BooksMapper booksMapper;
    @PostMapping
        public BookResponseDto addBooks(@RequestBody BookRequestDto dto){
            return booksService.addBooks(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBooks(@PathVariable("id") Long id){
         booksService.deleteBook(id);
    }

    @GetMapping
    public List<BookResponseDto> getBooks(){
       List<BookEntity> data = booksService.getBooks();
        return data.stream().map(booksMapper::toDto).toList();
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@RequestBody BookRequestDto dto, @PathVariable("id") Long id){
        //bul-değiştir-kaydet
       return booksService.updateBooks(dto,id);

    }
}
