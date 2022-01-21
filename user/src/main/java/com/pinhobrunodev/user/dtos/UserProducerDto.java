package com.pinhobrunodev.user.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserProducerDto  implements Serializable {


    private String nome;
    private String actionType;

}
