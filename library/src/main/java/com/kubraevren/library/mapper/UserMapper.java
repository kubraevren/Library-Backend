package com.kubraevren.library.mapper;

import com.kubraevren.library.dto.UserRequestDto;
import com.kubraevren.library.dto.UserResponseDto;
import com.kubraevren.library.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(UserEntity entity){
        UserResponseDto dto=new UserResponseDto();

        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());

        return dto;
    }


    public UserEntity toEntity(UserRequestDto dto){
        UserEntity entity=new UserEntity();

        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
