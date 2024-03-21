package com.shopnow.userms.controller;

import com.shopnow.userms.conf.ResourceNotFoundException;
import com.shopnow.userms.entity.dto.PassDTO;
import com.shopnow.userms.entity.dto.UserDTO;
import com.shopnow.userms.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    ServiceUser serviceUser;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {

        UserDTO user = serviceUser.findByUserId(id)
                 // map to DTO
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        return ResponseEntity.ok(user);
    }
    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        return new ResponseEntity<>(serviceUser.save(user), HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> alterUser(@PathVariable Long id, @RequestBody UserDTO user) {
        return new ResponseEntity<>(serviceUser.save(user), HttpStatus.OK);
    }

    @PatchMapping("/password")
    public ResponseEntity<Boolean> alterPassword(@RequestBody PassDTO pass) throws Exception{
        return new ResponseEntity<>(serviceUser.savePass(pass), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam String username, @RequestParam String password) {
        UserDTO user = serviceUser.findByUserUsernameAndPassword(username, password)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
        return ResponseEntity.ok(user);
    }
}