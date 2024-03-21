package com.shopnow.userms.service;

import com.shopnow.userms.entity.User;
import com.shopnow.userms.repo.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private RepositoryUser usuarioJPA;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> usuario = usuarioJPA.findByUsername(s);
        if (usuario.isPresent()){
            return usuario.get();
        }
        throw new UsernameNotFoundException("Invalid data!");
    }
}