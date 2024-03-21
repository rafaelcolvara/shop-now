package com.shopnow.orderms.service;

import com.shopnow.orderms.entity.User;
import com.shopnow.orderms.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientValidationService {

    private final RestTemplate restTemplate;
    @Autowired
    public ClientValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${client.service.url}:${client.service.port}")
    private String url ;

    public UserDTO clienteExiste(Long codigoCliente) throws Exception {

        try {
            return restTemplate.getForObject(url + "/user/" + codigoCliente, UserDTO.class) ;
        } catch (Exception e) {
            throw new Exception("Cliente não encontrado");
        }
    }

}
