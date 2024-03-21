package com.shopnow.orderms.resource;

import com.shopnow.orderms.conf.ResourceNotFoundException;
import com.shopnow.orderms.entity.Order;
import com.shopnow.orderms.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class ResourceOrder {

    @Autowired
    ServiceOrder serviceOrder;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

        Order order = serviceOrder.findByOrderId(id).orElseThrow(() -> new ResourceNotFoundException("Order not found: " + id));
        return ResponseEntity.ok(order);
    }
    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(Order order) {
        return handleOrderOperation(order, HttpStatus.CREATED);
    }

    @PatchMapping("/order/{id}")
    public ResponseEntity<Order> alterOrder(@PathVariable Long id, @RequestBody Order order) {
        return handleOrderOperation(order, HttpStatus.OK);
    }

    private ResponseEntity<Order> handleOrderOperation(Order order, HttpStatus status) {
        try {
            return new ResponseEntity<>(serviceOrder.save(order), status);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}