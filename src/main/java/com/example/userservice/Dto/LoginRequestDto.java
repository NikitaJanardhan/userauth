package com.example.userservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequestDto {
    private String email;
    private String password;
}
