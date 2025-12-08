package com.kubraevren.library.dto;

import com.kubraevren.library.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {

    private Long serialNo;
    private String title;
    private String author;
    private int pageCount;
    private BookStatus status;
    private String category;
    private String imageUrl;
    private Long userId;

}