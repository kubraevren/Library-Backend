package com.kubraevren.library.controller;
import com.kubraevren.library.dto.BookRequestDto;
import com.kubraevren.library.dto.BookResponseDto;
import com.kubraevren.library.service.BooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("books")
@RestController
public class BooksController {
    private final BooksService booksService;

    @PostMapping
        public BookResponseDto addBooks(@Valid  @RequestBody BookRequestDto dto){
            return booksService.addBooks(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBooks(@PathVariable("id") Long id){
         booksService.deleteBook(id);
    }

    @GetMapping
    public List<BookResponseDto> getBooks(){
        return booksService.getBooks();

    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@Valid @RequestBody BookRequestDto dto, @PathVariable("id") Long id){
       return booksService.updateBooks(dto,id);

    }
}
