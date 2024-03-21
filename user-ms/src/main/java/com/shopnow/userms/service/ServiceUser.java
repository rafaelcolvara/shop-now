package com.shopnow.userms.service;

import com.shopnow.userms.entity.User;
import com.shopnow.userms.entity.dto.PassDTO;
import com.shopnow.userms.entity.dto.UserDTO;
import com.shopnow.userms.repo.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceUser {

    @Autowired
    RepositoryUser repositoryUser;


    public Optional<UserDTO> findByUserId(Long id) {
        return repositoryUser.findById(id)
                .map(this::convertToUserDTO);
    }
    private UserDTO convertToUserDTO(User user) {

        return new UserDTO( user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFullName());
    }

    private User convertToUser(UserDTO user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        return newUser;
    }
    public UserDTO save(UserDTO user) {

        return convertToUserDTO(repositoryUser.save(convertToUser(user)));

    }

    public Boolean savePass(PassDTO pass) {
        if (repositoryUser.updatePassword(pass.getIdUser(), pass.getPassword()) != 1 ) {
            throw new RuntimeException("Erro ao alterar senha");
        }
        return true;
    }


    public Optional<UserDTO> findByUserUsernameAndPassword(String username, String password) {

        return repositoryUser.findByUsernameAndPassword(username, password)
                .map(this::convertToUserDTO);
    }


}
