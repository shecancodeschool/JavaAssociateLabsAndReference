package org.eddydashcode.java_design_patterns.structural.facade.shopping_cart.service;

public class PaymentService {

    public void checkout(double amount) {
        System.out.println("Payment of $" + amount + " completed.");
    }
}
