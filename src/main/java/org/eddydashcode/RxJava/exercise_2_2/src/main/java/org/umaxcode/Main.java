// src/main/java/org/eddydashcode/Main.java
package org.eddydashcode;

import io.reactivex.rxjava3.coreqqqqqq.Observable;

public class Main {

    public static void main(String[] args) {
        Observable<Integer> numbers = Observable.range(1, 10);

        numbers
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .subscribe(
                        item -> System.out.println("Received: " + item),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Stream complete")
                );
    }
}