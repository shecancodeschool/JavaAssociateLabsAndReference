package org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring;

import org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.observer.Investor;
import org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.subject.Stock;

public class ClientApplication {
    public static void main(String[] args) {
        Stock apple = new Stock("AAPL", 150.00);
        Stock google = new Stock("GOOG", 2800.00);

        Investor alice = new Investor("Alice");
        Investor bob = new Investor("Bob");

        apple.registerObserver(alice);
        apple.registerObserver(bob);
        google.registerObserver(bob);

        apple.setPrice(152.00);  // both Alice and Bob are notified
        System.out.println(); // for spacing
        google.setPrice(2815.00); // only Bob is notified
    }
}
