package com.shopnow.userms.service;

import com.shopnow.userms.controller.ControllerUser;
import com.shopnow.userms.entity.User;
import com.shopnow.userms.entity.dto.PassDTO;
import com.shopnow.userms.entity.dto.UserDTO;
import com.shopnow.userms.entity.dto.UserUpdateDTO;
import com.shopnow.userms.repo.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Link;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceUser {

    @Autowired
    RepositoryUser repositoryUser;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public Optional<UserDTO> findByUserId(Long id) {
        return repositoryUser.findById(id)
                .map(UserDTO::new);
    }

    private User convertToUser(UserDTO user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        return newUser;
    }
    public UserDTO addUser(UserDTO user) {

        User userSaved = repositoryUser.save(new User(user));

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ControllerUser.class)
                .getUserById(userSaved.getId())).withSelfRel();
        userSaved.add(selfLink);

        return new UserDTO(userSaved);
    }

    public UserUpdateDTO updateUser(String username, UserUpdateDTO user) {

        User userUpdate = repositoryUser.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found: " + username));
        userUpdate.setEmail(user.getEmail());
        userUpdate.setFullName(user.getFullName());
        userUpdate.setUsername(user.getUsername());
        user.setId(repositoryUser.save(userUpdate).getId());

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ControllerUser.class)
                .getUserById(user.getId())).withSelfRel();
        user.add(selfLink);

        return  user;
    }
    public Boolean savePass(PassDTO pass) {
        String pasw = new BCryptPasswordEncoder().encode(pass.getPassword());
        if (repositoryUser.updatePassword(pass.getIdUser(), pasw) != 1 ) {
            throw new RuntimeException("Error updating password.");
        }
        return true;
    }

    public Optional<UserDTO> findByUserUsername(String username) {
        return repositoryUser.findByUsername(username)
                .map(UserDTO::new);
    }

    public Iterable<UserDTO> findAll() {
        return repositoryUser.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }




}
