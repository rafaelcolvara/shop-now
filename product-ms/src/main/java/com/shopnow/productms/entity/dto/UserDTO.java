package com.shopnow.productms.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    private String username;

    private String token;

    private String status;
    public UserDTO( String token, String status, String username) {
        this.token = token;
        this.username = username;
        this.status = status;
    }

}
