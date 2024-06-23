package com.thilina.personalized_data_core.service;

import com.thilina.personalized_data_core.dto.ShelfProductDTO;
import com.thilina.personalized_data_core.dto.ShopperShelfDTO;
import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.model.ShopperProduct;
import com.thilina.personalized_data_core.repository.ProductMetadataRepository;
import com.thilina.personalized_data_core.repository.ShopperProductRepository;
import com.thilina.personalized_data_core.util.CacheManagementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InternalService {

    private static final Logger LOG = LoggerFactory.getLogger(InternalService.class);
    private final ProductMetadataRepository productMetadataRepository;
    private final ShopperProductRepository shopperProductRepository;
    private final CacheManagementService cacheManagementService;

    public void saveProductMetadata(final ProductMetadata productMetadata) {
        final ProductMetadata existingProductMetadata = productMetadataRepository.findByProductId(productMetadata.getProductId());
        if (existingProductMetadata != null) {
            LOG.info("Product with ID {} already exists. Updating the existing product.", productMetadata.getProductId());
            existingProductMetadata.setCategory(productMetadata.getCategory());
            existingProductMetadata.setBrand(productMetadata.getBrand());
            productMetadataRepository.save(existingProductMetadata);
        } else {
            productMetadataRepository.save(productMetadata);
        }
    }

    public void saveShopperProducts(final ShopperShelfDTO shopperShelfDTO) {
        for (ShelfProductDTO shelfProductDTO : shopperShelfDTO.getShelf()) {
            if (!productMetadataRepository.existsByProductId(shelfProductDTO.getProductId())) {
                throw new IllegalArgumentException("Product with ID " + shelfProductDTO.getProductId() + " does not exist");
            }
        }

        final List<ShopperProduct> shopperProducts = mapToShopperProductList(shopperShelfDTO);
        shopperProductRepository.saveAll(shopperProducts);

        cacheManagementService.evictAllProductsByShopperCaches(shopperShelfDTO.getShopperId());
    }

    private List<ShopperProduct> mapToShopperProductList(final ShopperShelfDTO shopperShelfDTO) {
        final List<ShopperProduct> shopperProducts = new ArrayList<>();
        for (ShelfProductDTO shelfProductDTO : shopperShelfDTO.getShelf()) {
            ShopperProduct shopperProduct = new ShopperProduct();
            shopperProduct.setShopperId(shopperShelfDTO.getShopperId());
            shopperProduct.setProductId(shelfProductDTO.getProductId());
            shopperProduct.setRelevancyScore(shelfProductDTO.getRelevancyScore());
            shopperProducts.add(shopperProduct);
        }
        return shopperProducts;
    }

}