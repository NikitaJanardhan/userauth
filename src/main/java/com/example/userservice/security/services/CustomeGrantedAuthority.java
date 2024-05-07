package com.example.userservice.security.services;

import com.example.userservice.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomeGrantedAuthority implements GrantedAuthority {
    public String role;

    public CustomeGrantedAuthority() {
    }

    public CustomeGrantedAuthority(Role role) {

        this.role = role.getName();
    }

    @Override
    public String getAuthority() {

        return role;
    }
}
