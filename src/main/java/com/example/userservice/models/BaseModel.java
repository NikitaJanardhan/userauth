package com.example.userservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@MappedSuperclass
@Getter
@Setter


public class BaseModel {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

}
