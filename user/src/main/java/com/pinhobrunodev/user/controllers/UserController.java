package com.pinhobrunodev.user.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinhobrunodev.user.dtos.UserDto;
import com.pinhobrunodev.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @JsonView(UserDto.UserView.UserRegister.class) UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDto));
    }
}
