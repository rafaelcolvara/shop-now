package com.shopnow.orderms.controller;

import com.shopnow.orderms.entity.dto.OrderDTO;
import com.shopnow.orderms.service.ServiceOrder;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class ControllerOrder {

    @Autowired
    ServiceOrder serviceOrder;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {

        OrderDTO order = serviceOrder.findByOrderId(id)
                 // map to DTO
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
        return ResponseEntity.ok(order);
    }
    @PostMapping()
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        return new ResponseEntity<>(serviceOrder.save(order), HttpStatus.CREATED) ;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDTO> alterOrder(@PathVariable Long id, @RequestBody OrderDTO order) {
        if (id == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        return new ResponseEntity<>(serviceOrder.save(order), HttpStatus.OK);
    }


}