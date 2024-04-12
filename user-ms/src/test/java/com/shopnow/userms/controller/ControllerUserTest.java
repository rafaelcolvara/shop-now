package com.shopnow.userms.controller;
import com.shopnow.userms.entity.User;
import com.shopnow.userms.entity.dto.UserDTO;
import com.shopnow.userms.service.ServiceUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ControllerUserTest {

    @InjectMocks
    private ControllerUser controllerUser;

    @Mock
    private ServiceUser serviceUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controllerUser = new ControllerUser(serviceUser, null, null, null);
    }

    @Test
    void shouldReturnUserWhenFindByUserIdIsCalled() {
        UserDTO expectedUser = new UserDTO(1L, "username", "password", "email", "fullName");
        when(serviceUser.findByUserId(1L)).thenReturn(Optional.of(expectedUser));

        ResponseEntity<UserDTO> response = controllerUser.getUserById(1L);

        assertEquals(expectedUser, response.getBody());
    }

    @Test
    void shouldReturnAllUsersWhenGetAllUsersIsCalled() {
        Iterable<UserDTO> expectedUsers = Arrays.asList(
                new UserDTO(1L, "username1", "password1", "email1", "fullName1"),
                new UserDTO(2L, "username2", "password2", "email2", "fullName2")
        );
        when(serviceUser.findAll()).thenReturn(expectedUsers);

        ResponseEntity<Iterable<UserDTO>> response = controllerUser.getAllUsers();

        assertEquals(expectedUsers, response.getBody());
    }
}