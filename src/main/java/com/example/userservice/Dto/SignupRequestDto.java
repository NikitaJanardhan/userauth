package com.example.userservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignupRequestDto {

    private  String email;
    private  String password;
    private String  name;
}
