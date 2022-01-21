package com.pinhobrunodev.user.services;

import com.pinhobrunodev.user.dtos.UserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);
}
