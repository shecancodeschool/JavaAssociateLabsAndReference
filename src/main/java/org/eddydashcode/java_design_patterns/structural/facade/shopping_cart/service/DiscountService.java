package org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.service;

public class DiscountService {

    public double applyDiscount(double total) {
        return total > 100 ? total * 0.9 : total;
    }
}
