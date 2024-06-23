package com.thilina.personalized_data_core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "product_metadata", indexes = {
    @Index(name = "idx_product_metadata_category", columnList = "category"),
    @Index(name = "idx_product_metadata_brand", columnList = "brand")
})
public class ProductMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "product_id", unique = true, nullable = false)
    private String productId;

    private String category;

    private String brand;
}
