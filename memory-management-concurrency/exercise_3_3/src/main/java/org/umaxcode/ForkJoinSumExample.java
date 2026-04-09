package org.eddydashcode;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumExample extends RecursiveTask<Long> {

    private final long[] array;
    private final int start, end;
    private static final int THRESHOLD = 1000;

    public ForkJoinSumExample(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            return Arrays.stream(this.array).sum();
        }

        int mid = (start + end) / 2;
        ForkJoinSumExample left = new ForkJoinSumExample(array, start, mid);
        ForkJoinSumExample right = new ForkJoinSumExample(array, mid, end);

        left.fork();
        right.fork();
        return left.join() + right.join();
    }


}
