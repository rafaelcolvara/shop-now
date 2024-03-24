package com.shopnow.orderms.controller;

import com.shopnow.orderms.entity.OrderItem;
import com.shopnow.orderms.entity.dto.OrderItemDTO;
import com.shopnow.orderms.service.ServiceOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItems")
public class ControllerOrderItem {

    @Autowired
    private ServiceOrderItem orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {

        return new ResponseEntity<>(orderItemService.save(orderItemDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        return orderItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemDTO orderItem) {
        return orderItemService.findById(id)
                .map(existingOrderItem -> {
                    orderItem.setId(id);
                    return new ResponseEntity<>(orderItemService.save(orderItem), HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}