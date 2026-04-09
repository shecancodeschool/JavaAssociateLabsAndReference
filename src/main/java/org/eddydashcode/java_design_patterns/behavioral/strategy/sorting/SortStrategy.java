package org.eddydashcode.java_design_patterns.behavioral.strategy.sorting;

public interface SortStrategy {

    void sort(int[] array);

    void swap(int[] array, int i, int j);
}
