package com.shopnow.userms.conf.JWT;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BearerTokenRefreshStrategy implements TokenRefreshStrategy {

    private final TokenService tokenService;

    public BearerTokenRefreshStrategy(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<?> refreshToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return tokenService.refreshToken(token.substring(7));
        }
        return null;
    }
}
