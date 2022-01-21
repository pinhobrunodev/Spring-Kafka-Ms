package com.pinhobrunodev.user.services.impl;

import com.pinhobrunodev.user.dtos.UserDto;
import com.pinhobrunodev.user.mapper.UserModelMapper;
import com.pinhobrunodev.user.repositories.UserRepository;
import com.pinhobrunodev.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserModelMapper mapper;

    @Override
    public UserDto saveUser(UserDto userDto) {
        var userModel = mapper.convertUserDtoToUserModel(userDto);
        userModel = userRepository.save(userModel);
        return userModel.convertToUserDto();
    }


}
