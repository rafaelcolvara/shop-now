package com.shopnow.orderms.service;

import com.shopnow.orderms.conf.ResourceNotFoundException;
import com.shopnow.orderms.conf.TokenManager;
import com.shopnow.orderms.entity.User;
import com.shopnow.orderms.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



@Service
public class ClientValidationService {
    private final TokenManager tokenManager;

    private final RestTemplate restTemplate;
    @Autowired
    public ClientValidationService(TokenManager tokenManager, RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
        this.restTemplate = restTemplate;
    }

    @Value("${client.service.url}:${client.service.port}")
    private String url ;

    private UserDTO makeRequest(Long codigoCliente){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",  "Bearer "+tokenManager.getJwtToken());

        // Criação da entidade Http que inclui o cabeçalho
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fazendo a requisição com o RestTemplate
        ResponseEntity<UserDTO> response = restTemplate.exchange(
                url + "/user/" + codigoCliente,
                HttpMethod.GET,
                entity,
                UserDTO.class);

        return response.getBody();
    }

    public UserDTO findClienteByCode(Long codigoCliente) throws Exception {

        try {
            return makeRequest(codigoCliente);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) { // Ou outra verificação específica para token expirado

                renewToken();

                return makeRequest(codigoCliente);
            } else {
                throw new ResourceNotFoundException("Client not found: " + codigoCliente);
            }
        }
    }

    private UserDTO renewToken() {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization",  "Bearer "+tokenManager.getJwtToken());

        HttpEntity<String> entity = new HttpEntity<>( headers);

        // Fazendo a requisição com o RestTemplate
        ResponseEntity<UserDTO> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                UserDTO.class);

        return response.getBody();

    }
}
