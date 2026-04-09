package org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.observer;

public interface Observer {

    void update(String symbol, double price);
}
