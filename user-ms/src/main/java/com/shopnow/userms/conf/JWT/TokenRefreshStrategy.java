package com.shopnow.userms.conf.JWT;

import org.springframework.http.ResponseEntity;

public interface TokenRefreshStrategy {
    ResponseEntity<?> refreshToken(String token);
}
