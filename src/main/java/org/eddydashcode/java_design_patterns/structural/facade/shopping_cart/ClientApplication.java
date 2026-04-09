package org.eddydashcode.java_design_patterns.structural.facade.shopping_cart;

import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.facade.ShoppingCartFacade;
import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.product.Product;

public class ClientApplication {

    public static void main(String[] args) {
        ShoppingCartFacade cart = new ShoppingCartFacade();

        Product laptop = new Product("Laptop", 1200.0, "SKU123");
        Product mouse = new Product("Mouse", 25.0, "SKU456");

        cart.addItem(laptop);
        cart.addItem(mouse);
        cart.checkout();
    }
}
