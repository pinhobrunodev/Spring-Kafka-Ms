package com.pinhobrunodev.user.mapper;

import com.pinhobrunodev.user.dtos.UserDto;
import com.pinhobrunodev.user.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper {


    public UserModel convertUserDtoToUserModel(UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto,userModel);
        return userModel;
    }


}
