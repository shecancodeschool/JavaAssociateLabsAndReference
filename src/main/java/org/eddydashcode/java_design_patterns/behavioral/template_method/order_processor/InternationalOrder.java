package org.eddydashcode.java_design_patterns.behavioral.template_method.order_processor;

public class InternationalOrder extends OrderProcessor {

    @Override
    protected void calculateShipping() {
        System.out.println("Calculating international shipping with customs fees...");
    }

    @Override
    protected void applyTaxes() {
        System.out.println("Applying international import taxes...");
    }

    @Override
    protected void sendConfirmation() {
        System.out.println("Sending international shipping confirmation with tracking info.");
    }
}


