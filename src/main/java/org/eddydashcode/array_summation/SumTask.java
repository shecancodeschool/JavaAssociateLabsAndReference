package org.eddydashcode.array_summation;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {

    private static int threshold = 5; // default threshold
    private final int[] array;

    public SumTask(int threshold, int[] array) {
        this(array);
        SumTask.threshold = threshold;
    }

    public SumTask(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {

        if (array.length < threshold) {
            return Arrays.stream(array).sum();
        }

        int mid = array.length / 2;

        int[] firstHalf = Arrays.copyOfRange(array, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(array, mid, array.length);

        SumTask left = new SumTask(firstHalf);
        left.fork();

        SumTask right = new SumTask(secondHalf);
        right.fork();

        return left.join() + right.join();
    }

    public static void main(String[] args) {
        try(ForkJoinPool forkJoinPool = new ForkJoinPool()){
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 4};

            SumTask task = new SumTask(array);
            int result = forkJoinPool.invoke(task);
            System.out.println("Result: " + result);
        }
    }
}
