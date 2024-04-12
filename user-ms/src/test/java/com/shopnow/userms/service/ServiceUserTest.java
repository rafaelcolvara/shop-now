package com.shopnow.userms.service;

import com.shopnow.userms.entity.User;
import com.shopnow.userms.entity.dto.PassDTO;
import com.shopnow.userms.entity.dto.UserDTO;
import com.shopnow.userms.entity.dto.UserUpdateDTO;
import com.shopnow.userms.repo.RepositoryUser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ServiceUserTest {

    @InjectMocks
    private ServiceUser serviceUser;

    @Mock
    private RepositoryUser repositoryUser;

    @Mock
    private User user;

    @Mock
    private UserDTO userDTO;

    @Mock
    private UserUpdateDTO userUpdateDTO;

    @Mock
    private PassDTO passDTO;



    @Test
    void findByUserIdReturnsUser() {
        given(repositoryUser.findById(user.getId())).willReturn(Optional.of(user));
        Optional<UserDTO> result = serviceUser.findByUserId(user.getId());
        assertTrue(result.isPresent());
        then(repositoryUser).should().findById(user.getId());
    }

    @Test
    void findByUserIdReturnsEmptyWhenUserNotFound() {
        given(repositoryUser.findById(user.getId())).willReturn(Optional.empty());
        Optional<UserDTO> result = serviceUser.findByUserId(user.getId());
        assertFalse(result.isPresent());
        then(repositoryUser).should().findById(user.getId());
    }

    @Test
    void addUserReturnsSavedUser() {

        UserDTO userDTOComSenha = new UserDTO(1L, "username", "password", "email", "fullName");

        given(repositoryUser.save(user)).willReturn(user);
        UserDTO result = serviceUser.addUser(userDTOComSenha);
        assertEquals(userDTOComSenha.getId(), result.getId());
    }

    @Test
    void updateUserReturnsUpdatedUser() {
        given(repositoryUser.findByUsername(Mockito.anyString())).willReturn(Optional.of(user));
        given(repositoryUser.save(Mockito.any(User.class))).willReturn(user);
        UserUpdateDTO result = serviceUser.updateUser("username", userUpdateDTO);
        assertEquals(userUpdateDTO.getId(), result.getId());
    }

    @Test
    void updateUserThrowsExceptionWhenUserNotFound() {
        given(repositoryUser.findByUsername(Mockito.anyString())).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> serviceUser.updateUser("username", userUpdateDTO));
    }

    @Test
    void savePassReturnsTrueWhenPasswordUpdated() {
        given(repositoryUser.updatePassword(Mockito.anyLong(), Mockito.anyString())).willReturn(1);
        Boolean result = serviceUser.savePass(passDTO);
        assertTrue(result);
    }

    @Test
    void savePassThrowsExceptionWhenPasswordNotUpdated() {
        given(repositoryUser.updatePassword(Mockito.anyLong(), Mockito.anyString())).willReturn(0);
        assertThrows(RuntimeException.class, () -> serviceUser.savePass(passDTO));
    }

    @Test
    void findByUserUsernameReturnsUser() {
        given(repositoryUser.findByUsername(Mockito.anyString())).willReturn(Optional.of(user));
        Optional<UserDTO> result = serviceUser.findByUserUsername("username");
        assertTrue(result.isPresent());
    }

    @Test
    void findByUserUsernameReturnsEmptyWhenUserNotFound() {
        given(repositoryUser.findByUsername(Mockito.anyString())).willReturn(Optional.empty());
        Optional<UserDTO> result = serviceUser.findByUserUsername("username");
        assertFalse(result.isPresent());
    }

    @Test
    void findAllReturnsAllUsers() {
        given(repositoryUser.findAll()).willReturn(Arrays.asList(user));
        List<UserDTO> result = (List<UserDTO>) serviceUser.findAll();
        assertFalse(result.isEmpty());
    }
}