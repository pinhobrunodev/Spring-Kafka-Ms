package com.pinhobrunodev.user.services.impl;

import com.pinhobrunodev.user.dtos.UserDto;
import com.pinhobrunodev.user.dtos.UserProducerDto;
import com.pinhobrunodev.user.enums.ActionType;
import com.pinhobrunodev.user.mapper.UserModelMapper;
import com.pinhobrunodev.user.repositories.UserRepository;
import com.pinhobrunodev.user.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserModelMapper mapper;
    @Autowired
    private RoutingKafkaTemplate routingKafkaTemplate;

    @Override
    public UserDto saveUser(UserDto userDto) {
        var userModel = mapper.convertUserDtoToUserModel(userDto);
        var userProducerDto = new UserProducerDto();
        userModel = userRepository.save(userModel);
        BeanUtils.copyProperties(userModel, userProducerDto);
        userProducerDto.setActionType(ActionType.CREATE.toString());
        routingKafkaTemplate.send("user-topic", userProducerDto);
        log.info("Message send : {}",userProducerDto.toString());
        return userModel.convertToUserDto();
    }


}
