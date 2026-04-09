package org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer;

public class CurrentConditionsDisplay implements Observer {

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current conditions: " + temperature + "C, " + humidity + "%s humidity, " + pressure + "hPa");
    }
}
