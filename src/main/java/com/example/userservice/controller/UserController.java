package com.example.userservice.controller;

import com.example.userservice.Dto.LoginRequestDto;
import com.example.userservice.Dto.SignupRequestDto;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private UserService1 userService1;

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequestDto SignupRequestDto) {

        String email = SignupRequestDto.getEmail();
        String password = SignupRequestDto.getPassword();
        String name = SignupRequestDto.getName();

        return userService1.signup(name, email, password);


    }

    @PostMapping("/login")
    public Token signup(@RequestBody LoginRequestDto loginRequestDto) {

        String email=loginRequestDto.getEmail();
        String password=loginRequestDto.getPassword();
        return  userService1.login(email,password);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestParam("token") String token){
        userService1.logout(token);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PostMapping("/validate/{token}")
    public boolean validateToken(@PathVariable("token") String token){
        return  userService1.validateToken(token);
    }
}