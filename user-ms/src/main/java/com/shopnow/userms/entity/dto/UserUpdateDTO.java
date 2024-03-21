package com.shopnow.userms.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.NonNull;


@Getter
@Setter
public class UserUpdateDTO extends RepresentationModel<UserUpdateDTO> {

    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String fullName;

    public UserUpdateDTO(Long id, String username, String password, String email, String fullName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
    }

}