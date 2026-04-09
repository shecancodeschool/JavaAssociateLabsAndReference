package org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.observer;

public class Investor implements Observer{

    private final String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println("[" + name + "] Notification: " + symbol + " is now $" + price);
    }
}
