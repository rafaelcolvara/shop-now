package com.shopnow.productms.controller;


import com.shopnow.productms.conf.ErrorHandling.ResourceNotFoundException;
import com.shopnow.productms.entity.dto.ProductDTO;
import com.shopnow.productms.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ControllerProduct {

    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

        ProductDTO productDTO = serviceProduct.findByProductId(id)
                 // map to DTO
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
        return ResponseEntity.ok(productDTO);
    }
    @PostMapping()
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO prod) {
        if (prod == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return new ResponseEntity<>(serviceProduct.save(prod), HttpStatus.CREATED) ;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> alterProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        if (productDTO == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return new ResponseEntity<>(serviceProduct.save(productDTO), HttpStatus.OK);
    }


}