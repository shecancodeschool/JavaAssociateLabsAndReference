package org.eddydashcode.java_design_patterns.behavioral.strategy.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ClientApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sorter sorter = new Sorter();

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sorter.setSortStrategy(new BubbleSort());
                break;
            case 2:
                sorter.setSortStrategy(new SelectionSort());
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Original array: " + Arrays.toString(array));
        sorter.sortArray(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
