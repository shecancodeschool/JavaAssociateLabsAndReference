package org.eddydashcode.functional_programming.exercise_3_1;

import java.util.List;
import java.util.function.Function;

public class LambdaPower {

    public static List<OrderItem> getOrderItems() {

        return List.of(
                new OrderItem("Book", 34.99),
                new OrderItem("Pen", 23.13),
                new OrderItem("Laptop", 789.99),
                new OrderItem("Mouse", 12.99)
        );
    }

    public static void main(String[] args) {

        List<OrderItem> items = getOrderItems();

        // Using an anonymous inner class
        double totalPrice = items.stream().map(new Function<OrderItem, Double>() {
                    @Override
                    public Double apply(OrderItem item) {
                        return item.price();
                    }
                })
                .reduce(0.0, Double::sum);

        System.out.println("Total price of OrderItems from anonymous inner class is: " + totalPrice);

        System.out.println(); // for spacing

        // Using lambda expression
        double totalPriceLambda = items.stream().map(OrderItem::price)
                .reduce(0.0, Double::sum);

        System.out.println("Total price of OrderItems from lambda function is: " + totalPriceLambda);

        System.out.println(); // for spacing

        // Using lambdas for filtering and transforming order items
        final double PRICE_THRESHOLD = 50.00;
        List<String> namesOfProductsWithPriceLessThanThreshold = items.stream()
                .filter(item -> item.price() < PRICE_THRESHOLD)
                .map(OrderItem::name)
                .toList();

        System.out.println("The list of products with price less than " + PRICE_THRESHOLD + " is : " + namesOfProductsWithPriceLessThanThreshold);

    }
}
