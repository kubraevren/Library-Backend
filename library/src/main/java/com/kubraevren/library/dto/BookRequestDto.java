package com.kubraevren.library.dto;

import com.kubraevren.library.enums.BookStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    @NotNull(message = "Seri numarası (ID) boş olamaz! Lütfen barkod veya ISBN giriniz.")
    private Long serialNo;

    @NotBlank(message = "Kitap başlığı boş olamaz!")
    private String title;

    @NotBlank(message = "Yazar adı boş olamaz!")
    private String author;

    @Min(value = 10, message = "Sayfa sayısı en az 10 olmalıdır!")
    private int pageCount;

    @NotNull(message = "Kitap durumu seçilmelidir!")
    private BookStatus status;

    private String category;
    private String imageUrl;



}