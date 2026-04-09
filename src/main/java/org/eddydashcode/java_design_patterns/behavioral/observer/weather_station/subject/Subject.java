package org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.subject;

import org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
