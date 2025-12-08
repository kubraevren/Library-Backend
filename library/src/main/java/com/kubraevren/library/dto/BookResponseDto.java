package com.kubraevren.library.dto;

import com.kubraevren.library.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {

    private Long serialNo;
    private String title;
    private String author;
    private int pageCount;
    private BookStatus status;
    private String category;
    private String imageUrl;
    private Long userId;
    private String addedBy;

}