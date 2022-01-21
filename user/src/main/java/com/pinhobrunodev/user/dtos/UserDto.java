package com.pinhobrunodev.user.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    public interface UserView {
        public static interface UserRegister {
        }
    }
    private String id;
    @JsonView(UserView.UserRegister.class)
    private String nome;
    private Instant criadoEm;
    private LocalDateTime atualizadoEm;


}
