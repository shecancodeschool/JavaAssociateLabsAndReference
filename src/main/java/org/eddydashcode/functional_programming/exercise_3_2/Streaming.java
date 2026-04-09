package org.eddydashcode.functional_programming.exercise_3_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streaming {

    public static List<Order> getOrders() {

        return List.of(
                new Order("customer-1", 120.5),
                new Order("customer-1", 220.5),
                new Order("customer-2", 85.0),
                new Order("customer-2", 95.0),
                new Order("customer-2", 105.0),
                new Order("customer-3", 45.5),
                new Order("customer-4", 200.0),
                new Order("customer-4", 100.0),
                new Order("customer-4", 50.0),
                new Order("customer-4", 20.0),
                new Order("customer-5", 60.0)
        );
    }

    public static void main(String[] args) {

        List<Order> orders = getOrders();

        double totalAmount = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.println("Total Order Amount: $" + totalAmount);

        System.out.println(); // for spacing

        Map<String, Long> orderCountPerCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.counting()
                ));

        orderCountPerCustomer.forEach((customer, count) ->
                System.out.println(customer + " has " + count + " orders")
        );

        System.out.println(); // for spacing

        Map<String, Double> totalAmountPerCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.summingDouble(Order::getAmount)
                ));

        totalAmountPerCustomer.forEach((customer, total) ->
                System.out.println(customer + " spent $" + total)
        );

        System.out.println(); // for spacing

        List<String> bigSpenders = orders.stream()
                .filter(order -> order.getAmount() > 100)
                .map(Order::getCustomerId)
                .distinct()
                .toList();

        System.out.println("Customers with orders > $100: " + bigSpenders);

    }
}
