package org.eddydashcode.java_design_patterns.behavioral.template_method.order_processor;

public class DomesticOrder extends OrderProcessor {

    @Override
    protected void calculateShipping() {
        System.out.println("Calculating standard domestic shipping...");
    }

    @Override
    protected void applyTaxes() {
        System.out.println("Applying local taxes for domestic order...");
    }
}
