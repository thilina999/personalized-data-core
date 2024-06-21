package com.thilina.personalized_data_core.dto;

import lombok.Data;

@Data
public class ShelfProductDTO {
    private String productId;
    private double relevancyScore;
}
