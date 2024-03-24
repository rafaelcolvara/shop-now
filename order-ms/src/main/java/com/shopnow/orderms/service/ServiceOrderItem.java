package com.shopnow.orderms.service;

import com.shopnow.orderms.conf.RestTemplate.RestTemplateService;
import com.shopnow.orderms.controller.ControllerOrderItem;
import com.shopnow.orderms.entity.Order;
import com.shopnow.orderms.entity.OrderItem;
import com.shopnow.orderms.entity.Product;
import com.shopnow.orderms.entity.dto.OrderItemDTO;
import com.shopnow.orderms.repo.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class ServiceOrderItem {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private RestTemplateService restTemplateService;

    private void validateOrderItem(OrderItemDTO orderItem) {
        if (Objects.isNull(orderItem)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item order cannot be null.");
        }
        if (Objects.isNull(orderItem.getIdProduct())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product ID cannot be null.");
        }
    }

    private void validateProductExists(Long productId) {
        try {
            restTemplateService.findProductByCode(productId);
        } catch (EntityNotFoundException | ResourceAccessException exception) {
            throw exception;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found.");
        }
    }

    private void addSelfLink(OrderItemDTO orderItem) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ControllerOrderItem.class)
                .getOrderItemById(orderItem.getId())).withSelfRel();
        orderItem.add(selfLink);
    }

    public OrderItemDTO save(OrderItemDTO orderItem)  {
        validateOrderItem(orderItem);
        validateProductExists(orderItem.getIdProduct());
        addSelfLink(orderItem);

        return convertToOrderItemDTO(orderItemRepository.save(convertToOrderItem(orderItem)));
    }

    public Optional<OrderItemDTO> findById(Long id) {
        return orderItemRepository
                .findById(id)
                .map(this::convertToOrderItemDTO);
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

    private OrderItemDTO convertToOrderItemDTO(OrderItem orderItem) {

        return new OrderItemDTO(orderItem.getId(),
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId(),
                orderItem.getQuantity(),
                orderItem.getPrice());
    }

    private OrderItem convertToOrderItem(OrderItemDTO orderItem) {
        return new OrderItem(orderItem.getId(),
                new Order(orderItem.getIdOrder()),
                new Product(orderItem.getIdProduct()),
                orderItem.getQuantity(),
                orderItem.getPrice());
    }
}