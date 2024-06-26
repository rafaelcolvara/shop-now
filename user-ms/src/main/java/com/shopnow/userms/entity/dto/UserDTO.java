package com.shopnow.userms.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


@Getter
@Setter
public class UserDTO  extends RepresentationModel<UserDTO> {

    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String fullName;

    public UserDTO(Long id, String username, String password, String email, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

}