package com.thilina.personalized_data_core.controller;

import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external/api/v1")
public class ExternalController {

    private final ExternalService externalService;

    @GetMapping(value = "/products", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductMetadata>> getProductsByShopper(
        @RequestParam String shopperId,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String brand,
        @RequestParam(defaultValue = "10") int limit) {
        List<ProductMetadata> products = externalService.getProductsByShopper(shopperId, category, brand, limit);
        return ResponseEntity.ok(products);
    }
}