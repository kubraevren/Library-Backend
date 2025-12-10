package com.kubraevren.library.service;

import com.kubraevren.library.dto.BookRequestDto;
import com.kubraevren.library.dto.BookResponseDto;
import com.kubraevren.library.exception.ApplicationException;
import com.kubraevren.library.mapper.BooksMapper;
import com.kubraevren.library.model.BookEntity;
import com.kubraevren.library.model.UserEntity;
import com.kubraevren.library.repository.BooksRepository;
import com.kubraevren.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final UserRepository userRepository;
    private final BooksMapper booksMapper;

    public BookResponseDto addBooks(BookRequestDto dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ApplicationException("Kullanıcı bulunamadı!"));
        BookEntity book = booksMapper.toEntity(dto);
        book.setUser(user);
        BookEntity savedBook = booksRepository.save(book);
        return booksMapper.toDto(savedBook);
    }

    public void deleteBook(Long id) {
        if (!booksRepository.existsById(id)) {
            throw new ApplicationException("Silinecek kitap bulunamadı! ID: " + id);
        }
        booksRepository.deleteById(id);
    }

    public List<BookResponseDto> getBooks() {
        return booksRepository.findAll()
                .stream()
                .map(booksMapper::toDto)
                .toList();
    }

    public BookResponseDto updateBooks(BookRequestDto dto, Long serial_no) {

        BookEntity book = booksRepository.findById(serial_no)
        .orElseThrow(() -> new ApplicationException("Kitap bulunamadı"));

            book.setAuthor(dto.getAuthor());
            book.setCategory(dto.getCategory());
            book.setPageCount(dto.getPageCount());
            book.setStatus(dto.getStatus());
            book.setImageUrl(dto.getImageUrl());
            book.setTitle(dto.getTitle());

          BookEntity  newBook= booksRepository.save(book);
         return  booksMapper.toDto(newBook);

    }
}