package org.eddydashcode.unleashing_the_power_of_java17.exercise_1_1;

public class Main {

    public static void main(String[] args) {

        Product productData = new Product("Laptop", 200.99, "IT");

        System.out.println("Product Name: " + productData.name());
        System.out.println("Product Price: " + productData.price());
        System.out.println("Product Category: " + productData.category());
    }
}
