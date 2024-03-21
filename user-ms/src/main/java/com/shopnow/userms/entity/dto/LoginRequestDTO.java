package com.shopnow.userms.entity.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginRequestDTO {

    private String username;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    public UsernamePasswordAuthenticationToken map() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
