package com.sst.movieflex.controllers;

import com.sst.movieflex.dtos.ResponseStatus;
import com.sst.movieflex.dtos.UserSignUpRequestDto;
import com.sst.movieflex.dtos.UserSignUpResponseDto;
import com.sst.movieflex.models.User;
import com.sst.movieflex.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto();
        User user = userService.signUp(userSignUpRequestDto.getName(), userSignUpRequestDto.getEmail(), userSignUpRequestDto.getPassword());

        userSignUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        userSignUpResponseDto.setName(user.getName());
        userSignUpResponseDto.setEmail(user.getEmail());

        return userSignUpResponseDto;


    }
}
