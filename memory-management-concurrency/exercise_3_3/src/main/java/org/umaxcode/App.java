package org.eddydashcode;

import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        long[] numbers = new long[100_000];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        ForkJoinPool pool = ForkJoinPool.commonPool();

        long result = pool.invoke(new ForkJoinSumExample(numbers, 0, numbers.length));
        System.out.println("Total sum: " + result);


    }
}
