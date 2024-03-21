package com.shopnow.orderms.entity.dto;

import com.shopnow.orderms.entity.Order;
import com.shopnow.orderms.entity.Product;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.math.BigDecimal;

@Getter
@Setter // (1)
public class OrderItemDTO {

    private Long id;
    private Long idOrder;

    private Long idProduct;

    private int quantity;
    private BigDecimal price;

    public OrderItemDTO(Long id, Long idOrder, Long idProduct, int quantity, BigDecimal price) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
    }
}
