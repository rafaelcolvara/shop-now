package com.shopnow.orderms.conf.RestTemplate;

import com.shopnow.orderms.conf.JWT.TokenManager;
import com.shopnow.orderms.entity.dto.ProductDTO;
import com.shopnow.orderms.entity.dto.UserDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



@Service
public class RestTemplateService {
    private final TokenManager tokenManager;

    private final RestTemplate restTemplate;
    @Autowired
    public RestTemplateService(TokenManager tokenManager, RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
        this.restTemplate = restTemplate;
    }

    @Value("${client.service.url}:${client.service.port}")
    private String urlCliente ;

    @Value("${product.service.url}:${product.service.port}")
    private String urlProduto ;


    public <T> T makeRequest(String url, HttpMethod method, HttpHeaders headers, Object body, ParameterizedTypeReference<T> responseType, Object... uriVariables) {
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        ResponseEntity<T> response = restTemplate.exchange(url, method, entity, responseType, uriVariables);
        return response.getBody();
    }

    public UserDTO findClienteByCode(Long codigoCliente) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",  "Bearer "+tokenManager.getJwtToken());

        try {
            return makeRequest(urlCliente + "/user/" + codigoCliente, HttpMethod.GET, headers, null, new ParameterizedTypeReference<UserDTO>() {});
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                renewToken();
                return makeRequest(urlCliente + "/user/" + codigoCliente, HttpMethod.GET, headers, null, new ParameterizedTypeReference<UserDTO>() {});
            } else {
                throw new EntityNotFoundException("Client not found: " + codigoCliente);
            }
        }
    }

    private UserDTO renewToken() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization",  "Bearer "+tokenManager.getJwtToken());

        return makeRequest(urlCliente + "/user/renew",
                HttpMethod.POST,
                headers,
                null,
                new ParameterizedTypeReference<UserDTO>() {});

    }

    public ProductDTO findProductByCode(Long productId) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",  "Bearer "+tokenManager.getJwtToken());

        try {
            return makeRequest(urlProduto + "/products/" + productId, HttpMethod.GET, headers, null, new ParameterizedTypeReference<ProductDTO>() {});
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                renewToken();
                return makeRequest(urlProduto + "/products/" + productId, HttpMethod.GET, headers, null, new ParameterizedTypeReference<ProductDTO>() {});
            } else {
                throw new EntityNotFoundException("Product not found: " + productId);
            }
        }
    }

}
