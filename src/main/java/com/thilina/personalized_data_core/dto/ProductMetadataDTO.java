package com.thilina.personalized_data_core.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductMetadataDTO implements Serializable {
    private String productId;
    private String category;
    private String brand;
}