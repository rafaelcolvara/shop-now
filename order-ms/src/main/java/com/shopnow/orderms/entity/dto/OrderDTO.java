package com.shopnow.orderms.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class OrderDTO extends RepresentationModel<OrderDTO> {

    private Long id;
    private Long orderNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal totalPrice;

    private Long idClient;

    public OrderDTO(Long id, Long orderNumber, LocalDateTime orderDate, BigDecimal totalPrice, Long idClient) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.idClient = idClient;

    }

}


