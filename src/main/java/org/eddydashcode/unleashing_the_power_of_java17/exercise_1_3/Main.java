package org.eddydashcode.unleashing_the_power_of_java17.exercise_1_3;

public class Main {

    public static void main(String[] args) {
        ProductCategory category = ProductCategory.ELECTRONICS;

        String label = switch (category){
            case FOOD -> """
                Organic food item.
                Keep refrigerated.
                Shelf life: 7 days.
                """;
            case CLOTHING -> """
                100% cotton.
                Machine washable.
                Sizes available: S to XL.
                """;
            case ELECTRONICS -> """
                Includes charger and manual.
                1-year warranty.
                Check voltage compatibility.
                """;
            case BOOKS -> """
                Paperback edition.
                Language: English.
                Free bookmark included.
                """;
            default -> "No description available.";

        };

        System.out.println("Category Label: " + label);

    }
}
