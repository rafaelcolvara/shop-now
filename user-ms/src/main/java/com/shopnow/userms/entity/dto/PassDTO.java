package com.shopnow.userms.entity.dto;

public class PassDTO {
    private String password;
    private Long idUser;


    public PassDTO() {
    }

    public PassDTO(Long idUser, String password) {
        this.password = password;
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }
    public Long getIdUser() {
        return idUser;
    }
}
