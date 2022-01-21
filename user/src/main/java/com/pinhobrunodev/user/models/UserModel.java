package com.pinhobrunodev.user.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pinhobrunodev.user.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class UserModel {

    @Id
    private String id;
    private String nome;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy hh:MM:ss",timezone = "UTC")
    private Instant criadoEm;
    @LastModifiedDate
    private LocalDateTime atualizadoEm;


    public UserDto convertToUserDto(){
        var userDto = new UserDto();
        BeanUtils.copyProperties(this,userDto);
        return userDto;
    }

}
