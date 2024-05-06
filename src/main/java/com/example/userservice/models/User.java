package com.example.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "user_self")
@Getter
@Setter

public class User extends BaseModel {

    private String name;
    private  String email;
    private String hashedPassword;

    @ManyToMany
    private List<Role>roles;
    private  boolean isEmailVerified;


}
