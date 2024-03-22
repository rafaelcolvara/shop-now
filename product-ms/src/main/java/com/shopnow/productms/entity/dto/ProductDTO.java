package com.shopnow.productms.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDTO(Long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

}


