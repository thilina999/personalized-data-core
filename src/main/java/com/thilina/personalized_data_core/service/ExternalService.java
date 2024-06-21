package com.thilina.personalized_data_core.service;

import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.repository.ShopperProductRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExternalService {
    private final ShopperProductRepository shopperProductRepository;

    public List<ProductMetadata> getProductsByShopper(final String shopperId, final String category, final String brand, final int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return shopperProductRepository.findProductsByShopperIdAndFilters(shopperId, category, brand, pageable);
    }
}