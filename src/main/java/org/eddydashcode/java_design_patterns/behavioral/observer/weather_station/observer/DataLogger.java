package org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer;

public class DataLogger implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Logging weather data: Temp=" + temperature +
                ", Humidity=" + humidity + ", Pressure=" + pressure);
    }
}
