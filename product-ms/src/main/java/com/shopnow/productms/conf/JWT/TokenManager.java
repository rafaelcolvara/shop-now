package com.shopnow.productms.conf.JWT;

import org.springframework.stereotype.Component;

@Component
public class TokenManager {

    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }


    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
