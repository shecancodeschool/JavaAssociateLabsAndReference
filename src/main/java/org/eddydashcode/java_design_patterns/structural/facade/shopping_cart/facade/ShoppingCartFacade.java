package org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.facade;

import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.product.Product;
import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.service.DiscountService;
import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.service.InventoryService;
import org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.service.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFacade {

    private final List<Product> cart = new ArrayList<>();
    private final InventoryService inventoryService = new InventoryService();
    private final DiscountService discountService = new DiscountService();
    private final PaymentService paymentService = new PaymentService();

    public void addItem(Product product) {
        if (inventoryService.isAvailable(product)) {
            cart.add(product);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println(product.getName() + " is out of stock.");
        }
    }

    public void checkout() {
        double total = cart.stream().mapToDouble(Product::getPrice).sum();
        double discountedTotal = discountService.applyDiscount(total);
        System.out.println("Original Total: $" + total);
        System.out.println("Discounted Total: $" + discountedTotal);
        paymentService.checkout(discountedTotal);
    }
}
