package org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.service;

import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.product.Product;

public class InventoryService {

    public boolean isAvailable(Product product) {
        // In real-world, check inventory DB
        return true;
    }
}
