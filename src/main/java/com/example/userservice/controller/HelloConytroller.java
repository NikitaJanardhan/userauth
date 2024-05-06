package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloConytroller {

    @GetMapping("/hi")
        public String Sayhi () {
            return "Hi";
        }
    }



