package com.thilina.personalized_data_core.service

import com.thilina.personalized_data_core.model.ProductMetadata
import com.thilina.personalized_data_core.repository.ShopperProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import spock.lang.Specification

class ExternalServiceTest extends Specification {

    ExternalService externalService
    def shopperProductRepository = Mock(ShopperProductRepository)

    def setup() {
        externalService = new ExternalService(shopperProductRepository)
    }

    def "UT_00003 - getProductsByShopper should return filtered ProductMetadata list"() {
        given:
            String shopperId = "S-1000"
            String category = "Babies"
            String brand = "Babyom"
            int limit = 10
            Pageable pageable = PageRequest.of(0, limit);

            def productMetadata1 = new ProductMetadata(productId: "P1", category: "Babies", brand: "Babyom")
            def productMetadata2 = new ProductMetadata(productId: "P2", category: "Toys", brand: "ToyBrand")

            shopperProductRepository.findProductsByShopperIdAndFilters(shopperId, category, brand, pageable) >> [productMetadata1]

        when:
            List<ProductMetadata> result = externalService.getProductsByShopper(shopperId, category, brand, limit)

        then:
            result.size() == 1
            result.contains(productMetadata1)
            !result.contains(productMetadata2)
    }
}
