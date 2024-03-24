package com.shopnow.productms.service;


import com.shopnow.productms.entity.Product;
import com.shopnow.productms.entity.dto.ProductDTO;
import com.shopnow.productms.repo.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ServiceProduct {

    @Autowired
    RepositoryProduct repository;


    public Optional<ProductDTO> findByProductId(Long id) {
        return repository.findById(id)
                .map(this::convertToProductDTO);
    }
    private ProductDTO convertToProductDTO(Product prod) {

        return new ProductDTO(prod.getId(),
                prod.getName(),
                prod.getDescription(),
                prod.getPrice());

    }

    private Product convertToProduct(ProductDTO pro) {

        Product product = new Product();
        product.setId(pro.getId());
        product.setName(pro.getName());
        product.setDescription(pro.getDescription());
        product.setPrice(pro.getPrice());
        return product;
    }
    public ProductDTO save(ProductDTO prod) {

        if (Objects.isNull(prod)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product cannot be null.");
        }

        return convertToProductDTO(repository.save(convertToProduct(prod)));

    }

    public List<ProductDTO> findByProductName(String name) {

        return new ArrayList<ProductDTO>();
    }

}
