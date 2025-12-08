package com.kubraevren.library.service;

import com.kubraevren.library.dto.BookRequestDto;
import com.kubraevren.library.dto.BookResponseDto;
import com.kubraevren.library.mapper.BooksMapper;
import com.kubraevren.library.model.BookEntity;
import com.kubraevren.library.model.UserEntity;
import com.kubraevren.library.repository.BooksRepository;
import com.kubraevren.library.repository.UserRepository; // User bulmak için lazım
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final UserRepository userRepository; // User'ı kontrol etmek için çağırdık
    private final BooksMapper booksMapper;

    public BookResponseDto addBooks(BookRequestDto dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));
        BookEntity book = booksMapper.toEntity(dto);
        book.setUser(user);
        BookEntity savedBook = booksRepository.save(book);
        return booksMapper.toDto(savedBook);
    }
    // 1. Önce kitabı ekleyen kullanıcıyı buluyoruz
    // 2. DTO'yu Entity'e çeviriyoruz
    // 3. Kitaba bulduğumuz kullanıcıyı atıyoruz (İlişkiyi kuruyoruz)
    // 4. Kaydediyoruz
    // 5. Sonucu tekrar DTO'ya çevirip dönüyoruz

    public void deleteBook(Long id) {
         booksRepository.deleteById(id);
    }

    public List<BookEntity> getBooks() {
       return booksRepository.findAll();
    }

    public BookResponseDto updateBooks(BookRequestDto dto, Long serial_no) {

        BookEntity book = booksRepository.findById(serial_no)
        .orElseThrow(() -> new RuntimeException("Kitap bulunamadı!"));

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