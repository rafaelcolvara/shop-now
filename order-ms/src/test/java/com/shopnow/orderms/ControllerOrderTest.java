package com.shopnow.orderms;


import com.shopnow.orderms.conf.ResourceNotFoundException;
import com.shopnow.orderms.entity.OrderItem;
import com.shopnow.orderms.controller.ControllerOrderItem;
import com.shopnow.orderms.controller.ControllerOrder;
import com.shopnow.orderms.entity.dto.OrderDTO;
import com.shopnow.orderms.service.ServiceOrderItem;
import com.shopnow.orderms.service.ServiceOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ControllerOrderTest {

    @InjectMocks
    ControllerOrder controllerOrder;
    @InjectMocks
    ControllerOrderItem controllerOrderItem;
    @Mock
    ServiceOrder serviceOrder;
    @Mock
    ServiceOrderItem serviceOrderItem;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void alterOrderReturnsOkStatusWhenOrderExists() {
        Long orderId = 1L;
        OrderDTO order = new OrderDTO(orderId, 1L, LocalDateTime.now(), BigDecimal.valueOf(100), 1L);
        when(serviceOrder.save(any(OrderDTO.class))).thenReturn(order);

        ResponseEntity<OrderDTO> response = controllerOrder.alterOrder(orderId, order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    public void alterOrderThrowsResourceNotFoundExceptionWhenOrderDoesNotExist() {
        Long orderId = 1L;
        OrderDTO order = new OrderDTO(orderId, 1L, LocalDateTime.now(), BigDecimal.valueOf(100), 1L);
        when(serviceOrder.save(any(OrderDTO.class))).thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class, () -> controllerOrder.alterOrder(orderId, order));
    }

    @Test
    public void alterOrderReturnsBadRequestWhenOrderIdIsNull() {
        OrderDTO order = new OrderDTO(1L, 1L, LocalDateTime.now(), BigDecimal.valueOf(100), 1L);

        assertThrows(IllegalArgumentException.class, () -> controllerOrder.alterOrder(null, order));
    }

    @Test
    public void alterOrderReturnsBadRequestWhenOrderIsNull() {
        assertThrows(IllegalArgumentException.class, () -> controllerOrder.alterOrder(1L, null));
    }





}