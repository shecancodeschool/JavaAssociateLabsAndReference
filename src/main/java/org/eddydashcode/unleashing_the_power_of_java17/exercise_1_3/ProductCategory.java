package org.eddydashcode.unleashing_the_power_of_java17.exercise_1_3;

public enum ProductCategory {
    FOOD("Food"),
    CLOTHING("Clothing"),
    ELECTRONICS("Electronics"),
    BOOKS("Books");

    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
