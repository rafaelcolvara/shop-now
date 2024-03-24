package com.shopnow.userms.entity.dto;

public class ResponseLoginDTO {
    private String token;
    private String status;

    private String username;

    public ResponseLoginDTO(String token, String status, String username) {
        this.token = token;
        this.status = status;
        this.username = username;

    }

    public String getToken() {
        return this.token;
    }

    public String getStatus() {
        return this.status;
    }


    public String getUsername() {
        return this.username;
    }



    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(String bearer) {
        this.status = bearer;
    }
}
