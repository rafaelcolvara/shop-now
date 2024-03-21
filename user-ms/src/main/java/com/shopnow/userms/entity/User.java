package com.shopnow.userms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 20)
    private String username;
    @Column(name = "password", length = 60, nullable = false)
    private String password;
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

}