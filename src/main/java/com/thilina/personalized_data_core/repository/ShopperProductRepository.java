package com.thilina.personalized_data_core.repository;

import com.thilina.personalized_data_core.model.ProductMetadata;
import com.thilina.personalized_data_core.model.ShopperProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProduct, Long> {
    @Query("SELECT sp FROM ShopperProduct sp WHERE sp.shopperId = :shopperId")
    List<ShopperProduct> findByShopperId(@Param("shopperId") String shopperId);

    @Query("SELECT pm FROM ShopperProduct sp JOIN ProductMetadata pm ON sp.productId = pm.productId " +
        "WHERE sp.shopperId = :shopperId " +
        "AND (:category IS NULL OR pm.category = :category) " +
        "AND (:brand IS NULL OR pm.brand = :brand)")
    List<ProductMetadata> findProductsByShopperIdAndFilters(@Param("shopperId") String shopperId,
                                                            @Param("category") String category,
                                                            @Param("brand") String brand);
}
