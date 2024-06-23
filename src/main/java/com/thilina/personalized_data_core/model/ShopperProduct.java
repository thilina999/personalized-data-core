package com.thilina.personalized_data_core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String shopperId;

    @NotNull
    @NotEmpty
    @Column(name = "product_id", nullable = false)
    private String productId;

    @NotNull
    @Column(nullable = false)
    private Double relevancyScore;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductMetadata productMetadata;
}