package com.kubraevren.library.controller;
import com.kubraevren.library.dto.UserRequestDto;
import com.kubraevren.library.dto.UserResponseDto;
import com.kubraevren.library.model.UserEntity;
import com.kubraevren.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RequestMapping("user")//http://localhost:8080/user
@RestController
public class UserController {

    private final UserService userService;
    @PostMapping
    public UserResponseDto addUser(@RequestBody UserRequestDto dto){
        return userService.addUser(dto);
    }
}
