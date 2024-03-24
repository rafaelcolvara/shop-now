package com.shopnow.orderms.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders") // 'order' is often a reserved keyword in SQL
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderNumber;
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public Order(Long idOrder) {
        this.id = idOrder;
    }
    public Order(){}
}
