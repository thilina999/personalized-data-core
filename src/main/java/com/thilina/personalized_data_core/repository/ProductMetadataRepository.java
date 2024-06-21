package com.thilina.personalized_data_core.repository;

import com.thilina.personalized_data_core.model.ProductMetadata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, Long> {
}