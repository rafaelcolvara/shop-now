package com.shopnow.userms.service;
import com.shopnow.userms.entity.User;
import com.shopnow.userms.repo.RepositoryUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private RepositoryUser usuarioJPA;

    @Mock
    private User user;

    @Test
    void loadUserByUsernameReturnsUserWhenUserExists() {
        given(usuarioJPA.findByUsername("username")).willReturn(Optional.of(user));
        UserDetails result = authService.loadUserByUsername("username");
        assertEquals(user, result);
    }

    @Test
    void loadUserByUsernameThrowsExceptionWhenUserDoesNotExist() {
        given(usuarioJPA.findByUsername("username")).willReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> authService.loadUserByUsername("username"));
    }
}