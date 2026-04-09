package org.eddydashcode.java_design_patterns.behavioral.template_method.order_processor;

public class ClientApplication {

    public static void main(String[] args) {
        OrderProcessor domestic = new DomesticOrder();
        domestic.processOrder();

        System.out.println("-----");

        OrderProcessor international = new InternationalOrder();
        international.processOrder();
    }
}
