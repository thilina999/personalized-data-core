package com.thilina.personalized_data_core.controller;

import com.thilina.personalized_data_core.dto.ShopperShelfDTO;
import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.service.InternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/api/v1")
public class InternalController {

    private final InternalService internalService;

    @PostMapping(value = "/product-metadata", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> saveProductMetadata(@RequestBody ProductMetadata productMetadata) {
        internalService.saveProductMetadata(productMetadata);
        return ResponseEntity.status(201).body("Product metadata saved");
    }

    @PostMapping(value = "/shopper-products", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> saveShopperProducts(@RequestBody ShopperShelfDTO shopperShelfDTO) {
        internalService.saveShopperProducts(shopperShelfDTO);
        return ResponseEntity.status(201).body("Shopper products saved");
    }

}
