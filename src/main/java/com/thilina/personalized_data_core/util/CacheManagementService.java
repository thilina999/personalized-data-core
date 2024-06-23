package com.thilina.personalized_data_core.util;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service

public class CacheManagementService {
    @CacheEvict(value = "productsByShopper", allEntries = true, key = "#shopperId + '*'")
    public void evictAllProductsByShopperCaches(final String shopperId) {
        // This method will remove all entries from the cache, where the key starts with shopperId
    }
}
