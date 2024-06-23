package com.thilina.personalized_data_core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductMetadataDTO {
    private String productId;
    private String category;
    private String brand;
}