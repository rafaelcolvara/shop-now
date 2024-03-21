package com.shopnow.orderms.service;

import com.shopnow.orderms.entity.OrderItem;
import com.shopnow.orderms.repo.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceOrderItem {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }
}