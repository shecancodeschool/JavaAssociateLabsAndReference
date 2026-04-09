package org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer;

public interface Observer {

    void update(float temperature, float humidity, float pressure);
}
