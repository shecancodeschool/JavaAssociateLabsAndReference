package org.eddydashcode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentMapExample {

    public static void main(String[] args) {
        String[] words = {
                "apple", "banana", "apple", "orange", "banana", "apple"
        };

        ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String word : words) {
            executor.submit(() -> wordCount.merge(word, 1, Integer::sum));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        wordCount.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
