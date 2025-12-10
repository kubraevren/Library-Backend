package com.kubraevren.library.mapper;

import com.kubraevren.library.dto.BookRequestDto;
import com.kubraevren.library.dto.BookResponseDto;
import com.kubraevren.library.model.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BooksMapper {

    public BookResponseDto toDto(BookEntity entity) {
        BookResponseDto dto = new BookResponseDto();
        dto.setSerialNo(entity.getSerialNo());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setPageCount(entity.getPageCount());
        dto.setStatus(entity.getStatus());
        dto.setCategory(entity.getCategory());
        dto.setImageUrl(entity.getImageUrl());

        if (entity.getUser() != null) {
            dto.setUserId(entity.getUser().getId());
            dto.setAddedBy(entity.getUser().getUsername());
        }
        return dto;
    }

    public BookEntity toEntity(BookRequestDto dto) {
        BookEntity entity = new BookEntity();
        entity.setSerialNo(dto.getSerialNo());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPageCount(dto.getPageCount());
        entity.setStatus(dto.getStatus());
        entity.setCategory(dto.getCategory());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

}