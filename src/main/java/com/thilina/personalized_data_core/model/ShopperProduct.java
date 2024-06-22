package com.thilina.personalized_data_core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "shopper_products", indexes = {
    @Index(name = "idx_shopper_products_shopper_id", columnList = "shopper_id"),
    @Index(name = "idx_shopper_products_product_id", columnList = "product_id")
})
public class ShopperProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String shopperId;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private Double relevancyScore;
}