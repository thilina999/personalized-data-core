package com.thilina.personalized_data_core.repository;

import com.thilina.personalized_data_core.model.ProductMetadata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, Long> {
    @Query("SELECT pm FROM ProductMetadata pm WHERE " +
        "(:category IS NULL OR pm.category = :category) AND " +
        "(:brand IS NULL OR pm.brand = :brand)")
    List<ProductMetadata> findByCategoryAndBrand(@Param("category") String category, @Param("brand") String brand);
}