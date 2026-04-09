package org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.subject;

import org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
      observers.remove(o);
    }

    @Override
    public void notifyObservers() {
       for(Observer o: observers){
           o.update(temperature, humidity, pressure);
       }
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
