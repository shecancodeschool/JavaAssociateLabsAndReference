package org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.product;

public class Product {
    private final String name;
    private final double price;
    private final String sku;

    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }
}
