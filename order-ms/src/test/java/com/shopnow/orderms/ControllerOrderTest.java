package com.shopnow.orderms;

import com.shopnow.orderms.entity.Order;
import com.shopnow.orderms.entity.OrderItem;
import com.shopnow.orderms.resource.ResourceOrderItem;
import com.shopnow.orderms.resource.ResourceOrder;
import com.shopnow.orderms.service.ServiceOrderItem;
import com.shopnow.orderms.service.ServiceOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ResourceOrderTest {

    @InjectMocks
    ResourceOrder resourceOrder;
    @InjectMocks
    ResourceOrderItem resourceOrderItem;
    @Mock
    ServiceOrder serviceOrder;
    @Mock
    ServiceOrderItem serviceOrderItem;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveOrderReturnsCreatedStatus() {
        Order order = new Order();
        when(serviceOrder.save(any(Order.class))).thenReturn(order);

        ResponseEntity<Order> response = resourceOrder.saveOrder(order);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    public void alterOrderReturnsCreatedStatus() {
        Order order = new Order();
        when(serviceOrder.save(any(Order.class))).thenReturn(order);

        ResponseEntity<Order> response = resourceOrder.alterOrder(1L, order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    public void saveOrderWithNullOrderReturnsBadRequest() {
        when(serviceOrder.save(null)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<Order> response = resourceOrder.saveOrder(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void alterOrderWithNullOrderReturnsBadRequest() {
        when(serviceOrder.save(null)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<Order> response = resourceOrder.alterOrder(1L,null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void alterItemOrderWithNullOrderReturnsNotFound() {
        when(serviceOrderItem.save(null)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<OrderItem> response = resourceOrderItem.updateOrderItem(1L, null);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}