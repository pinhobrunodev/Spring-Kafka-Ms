package com.pinhobrunodev.course.services.impl;

import com.pinhobrunodev.course.models.UserModel;
import com.pinhobrunodev.course.repositories.UserRepository;
import com.pinhobrunodev.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserModel userModel) {
        userRepository.save(userModel);
    }
}
