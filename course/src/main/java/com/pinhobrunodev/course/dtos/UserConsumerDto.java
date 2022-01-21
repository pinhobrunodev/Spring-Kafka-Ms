package com.pinhobrunodev.course.dtos;

import com.pinhobrunodev.course.models.UserModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserConsumerDto implements Serializable {

    private String nome;
    private String actionType;



    public UserModel convertToUserModel(){
        var userModel = new UserModel();
        BeanUtils.copyProperties(this,userModel);
        return userModel;
    }
}
