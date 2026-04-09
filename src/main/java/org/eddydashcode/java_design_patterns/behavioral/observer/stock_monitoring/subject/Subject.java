package org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.subject;


import org.eddydashcode.java_design_patterns.behavioral.observer.stock_monitoring.observer.Observer;

public interface Subject {

    void registerObserver(Observer o);

    void unregisterObserver(Observer o);

    void notifyObservers();
}
