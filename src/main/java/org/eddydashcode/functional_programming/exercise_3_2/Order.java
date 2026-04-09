package org.eddydashcode.functional_programming.exercise_3_2;

public class Order {

    private final String customerId;
    private final double amount;

    public Order(String customerId, double amount){
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }
}
