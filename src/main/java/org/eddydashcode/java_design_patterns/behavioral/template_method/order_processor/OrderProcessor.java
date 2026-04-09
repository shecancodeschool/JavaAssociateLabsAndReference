package org.eddydashcode.java_design_patterns.behavioral.template_method.order_processor;

public abstract class OrderProcessor {

    public final void processOrder(){
        validateItems();
        calculateShipping();
        applyTaxes();
        sendConfirmation();
    }

    // Steps with default or abstract behavior
    protected void validateItems() {
        System.out.println("Validating items in the cart...");
    }

    protected abstract void calculateShipping();

    protected abstract void applyTaxes();

    protected void sendConfirmation() {
        System.out.println("Sending order confirmation email.");
    }
}
