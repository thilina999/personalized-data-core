package com.thilina.personalized_data_core.dto;

import java.util.List;
import lombok.Data;

@Data
public class ShopperProductsDTO {
    private String shopperId;
    private List<ShelfProductDTO> shelf;
}
