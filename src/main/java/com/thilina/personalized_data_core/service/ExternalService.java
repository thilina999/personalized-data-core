package com.thilina.personalized_data_core.service;

import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.repository.ProductMetadataRepository;
import com.thilina.personalized_data_core.repository.ShopperProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExternalService {
    private final ShopperProductRepository shopperProductRepository;
    private final ProductMetadataRepository productMetadataRepository;

    public List<ProductMetadata> getProductsByShopper(final String shopperId, final String category, final String brand, final int limit) {

        List<ProductMetadata> productMetadata = shopperProductRepository.findProductsByShopperIdAndFilters(shopperId, category, brand);
        return productMetadata.stream().limit(limit).toList();
    }
}