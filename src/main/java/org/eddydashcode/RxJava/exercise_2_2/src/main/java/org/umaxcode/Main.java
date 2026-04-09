package org.eddydashcode;

import io.reactivex.rxjava3.core.Observable;

public class Main {

    public static void main(String[] args) {
        // Create an Observable that emits integers from 1 to 10
        Observable<Integer> numbers = Observable.range(1, 10);

        numbers
                // Filter to only even numbers
                .filter(num -> num % 2 == 0)
                // Map each number to its square
                .map(num -> num * num)
                // Subscribe to receive and print the results
                .subscribe(
                        item -> System.out.println("Received: " + item),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Stream complete")
                );
    }
}
