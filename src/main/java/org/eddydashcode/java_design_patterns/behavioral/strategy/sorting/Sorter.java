package org.eddydashcode.java_design_patterns.behavioral.strategy.sorting;

public class Sorter {

    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        if (strategy == null) {
            throw new IllegalArgumentException("Sort strategy not set.");
        }

        strategy.sort(array);
    }
}
