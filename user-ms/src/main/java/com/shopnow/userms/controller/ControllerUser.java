package com.shopnow.userms.controller;

import com.shopnow.userms.conf.ResourceNotFoundException;
import com.shopnow.userms.entity.dto.*;
import com.shopnow.userms.service.ServiceUser;
import com.shopnow.userms.conf.JWT.TokenRefreshStrategy;
import com.shopnow.userms.conf.JWT.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    ServiceUser serviceUser;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    private final TokenRefreshStrategy tokenRefreshStrategy;

    public ControllerUser(ServiceUser serviceUser, AuthenticationManager authenticationManager, TokenService tokenService, TokenRefreshStrategy tokenRefreshStrategy) {
        this.serviceUser = serviceUser;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.tokenRefreshStrategy = tokenRefreshStrategy;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {

        UserDTO user = serviceUser.findByUserId(id)
                // map to DTO
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        System.out.println("Entrou na controller");
        return new ResponseEntity<>(serviceUser.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserUpdateDTO> alterUser(@PathVariable String username, @RequestBody UserUpdateDTO user) {
        return new ResponseEntity<>(serviceUser.updateUser(username, user), HttpStatus.OK);
    }

    @PatchMapping("/password")
    public ResponseEntity<Boolean> alterPassword(@RequestBody PassDTO pass) throws Exception {
        return new ResponseEntity<>(serviceUser.savePass(pass), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UserDTO user = serviceUser.findByUserUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + loginRequestDTO.getUsername()));

        Authentication authentication = authenticationManager.authenticate(loginRequestDTO.map());
        String token = tokenService.gerarToken(authentication);

        ResponseLoginDTO response = new ResponseLoginDTO(token, "LOGGED IN", loginRequestDTO.getUsername());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshAccessToken(HttpServletRequest request) {
        String refreshToken = request.getHeader("Authorization");
        return tokenRefreshStrategy.refreshToken(refreshToken);
    }
}