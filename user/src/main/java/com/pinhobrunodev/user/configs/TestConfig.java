package com.pinhobrunodev.user.configs;

import com.pinhobrunodev.user.UserRepository;
import com.pinhobrunodev.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown");
        User alex = new User(null, "Alex Green");

        userRepository.saveAll(Arrays.asList(maria, alex));
    }

}
