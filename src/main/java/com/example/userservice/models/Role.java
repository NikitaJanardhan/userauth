package com.example.userservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "role_user")
@Getter
@Setter

public class Role extends BaseModel{
    private String name;

}
