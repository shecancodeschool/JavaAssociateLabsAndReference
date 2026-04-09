package org.eddydashcode.fibonacci;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFibonacci extends RecursiveTask<Long> {

    private final int n;
    private static final ConcurrentHashMap<Integer, Long> fibonacciMemo = new ConcurrentHashMap<>();

    public ForkJoinFibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {

        if(n <= 1) return (long) n;

        // Check if already computed
        if (fibonacciMemo.containsKey(n)) {
            return fibonacciMemo.get(n);
        }

        // using the compute-one-folk-one design pattern
        ForkJoinFibonacci task1 = new ForkJoinFibonacci(n - 1);
        Long computeTask1 = task1.compute();

        ForkJoinFibonacci task2 = new ForkJoinFibonacci(n - 2);
        task2.fork();

        Long result = computeTask1 + task2.join();
        fibonacciMemo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int n = 100;
        ForkJoinFibonacci task = new ForkJoinFibonacci(n);
        System.out.println(pool.invoke(task));
        long result = pool.invoke(task);

        System.out.println("Fibonacci result: " + result);
    }
}
