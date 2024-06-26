package com.shopnow.orderms.service;

import com.shopnow.orderms.conf.RestTemplate.RestTemplateService;
import com.shopnow.orderms.entity.Order;
import com.shopnow.orderms.entity.User;
import com.shopnow.orderms.entity.dto.OrderDTO;

import com.shopnow.orderms.repo.RepositoryOrder;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ServiceOrder {

    @Autowired
    RepositoryOrder repositoryOrder;

    @Autowired
    RestTemplateService clienteValidationService;


    public Optional<OrderDTO> findByOrderId(Long id) {
        return repositoryOrder.findById(id)
                .map(this::convertToOrderDTO);
    }
    private OrderDTO convertToOrderDTO(Order order) {

        return new OrderDTO(order.getId(),
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getUser().getId());
    }

    private Order convertToOrder(OrderDTO order) {
        User userRef = new User();
        Order newOrder = new Order(order.getId());
        newOrder.setOrderNumber(order.getOrderNumber());
        newOrder.setOrderDate(order.getOrderDate());
        newOrder.setTotalPrice(order.getTotalPrice());
        userRef.setId(order.getIdClient());
        newOrder.setUser(userRef);
        return newOrder;
    }
    public OrderDTO save(OrderDTO order) {
        if (Objects.isNull(order)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order cannot be null.");
        }
        if (Objects.isNull(order.getIdClient())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client ID cannot be null.");
        }
        try {
            clienteValidationService.findClienteByCode(order.getIdClient());
        } catch (EntityNotFoundException re) {
            throw re;
        } catch (ResourceAccessException re) {
            throw re;
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found.");
        }

        return convertToOrderDTO(repositoryOrder.save(convertToOrder(order )));

    }


}
