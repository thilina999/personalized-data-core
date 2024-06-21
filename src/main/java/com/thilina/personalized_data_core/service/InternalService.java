package com.thilina.personalized_data_core.service;

import com.thilina.personalized_data_core.dto.ShelfProductDTO;
import com.thilina.personalized_data_core.dto.ShopperProductsDTO;
import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.model.ShopperProduct;
import com.thilina.personalized_data_core.repository.ProductMetadataRepository;
import com.thilina.personalized_data_core.repository.ShopperProductRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InternalService {

    private final ProductMetadataRepository productMetadataRepository;
    private final ShopperProductRepository shopperProductRepository;

    public void saveProductMetadata(final ProductMetadata productMetadata) {
        productMetadataRepository.save(productMetadata);
    }

    public void saveShopperProducts(final ShopperProductsDTO shopperProductsDTO) {
        List<ShopperProduct> shopperProducts = mapToShopperProductList(shopperProductsDTO);
        shopperProductRepository.saveAll(shopperProducts);
    }

    private List<ShopperProduct> mapToShopperProductList(final ShopperProductsDTO shopperProductsDTO) {
        List<ShopperProduct> shopperProducts = new ArrayList<>();
        for (ShelfProductDTO shelfProductDTO : shopperProductsDTO.getShelf()) {
            ShopperProduct shopperProduct = new ShopperProduct();
            shopperProduct.setShopperId(shopperProductsDTO.getShopperId());
            shopperProduct.setProductId(shelfProductDTO.getProductId());
            shopperProduct.setRelevancyScore(shelfProductDTO.getRelevancyScore());
            shopperProducts.add(shopperProduct);
        }
        return shopperProducts;
    }

}