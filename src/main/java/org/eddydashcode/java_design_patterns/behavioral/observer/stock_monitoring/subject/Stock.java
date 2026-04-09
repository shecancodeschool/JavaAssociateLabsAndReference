package org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.subject;

import org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {

    private final String symbol;
    private double price;
    private final List<Observer> observers = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }

    public void setPrice(double price) {
        if (this.price != price) {
            this.price = price;
            notifyObservers();
        }
    }
}
