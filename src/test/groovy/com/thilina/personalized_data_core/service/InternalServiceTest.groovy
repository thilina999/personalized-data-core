package com.thilina.personalized_data_core.service

import com.thilina.personalized_data_core.dto.ShelfProductDTO
import com.thilina.personalized_data_core.dto.ShopperShelfDTO
import com.thilina.personalized_data_core.model.ProductMetadata
import com.thilina.personalized_data_core.repository.ProductMetadataRepository
import com.thilina.personalized_data_core.repository.ShopperProductRepository
import spock.lang.Specification

class InternalServiceTest extends Specification {

    InternalService internalService

    def productMetadataRepository = Mock(ProductMetadataRepository)
    def shopperProductRepository = Mock(ShopperProductRepository)

    def setup() {
        internalService = new InternalService(productMetadataRepository, shopperProductRepository)
    }

    def "UT_00001 - saveProductMetadata should store Product Metadata in the repository"() {
        given:
            def productMetadata = new ProductMetadata(productId: "P1", category: "Babies", brand: "Babyom")

        when:
            internalService.saveProductMetadata(productMetadata)

        then:
            1 * productMetadataRepository.save(productMetadata)
    }

    def "UT_00002 - saveShopperProducts should store ShopperProducts in the repository"() {
        given:
            def shopperProducts = [
                new ShelfProductDTO(productId: "P1", relevancyScore: 50.0),
                new ShelfProductDTO(productId: "P2", relevancyScore: 30.0)
            ]
            def shopperShelfDTO = new ShopperShelfDTO(shopperId: "S-1000", shelf: shopperProducts)
            productMetadataRepository.existsByProductId(_ as String) >> true

        when:
            internalService.saveShopperProducts(shopperShelfDTO)

        then:
            noExceptionThrown()
    }

}
