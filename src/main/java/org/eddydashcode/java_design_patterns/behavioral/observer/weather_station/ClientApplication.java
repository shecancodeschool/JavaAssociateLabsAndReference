package org.eddydashcode.java_design_patterns.behavioral.observer.weather_station;

import org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer.CurrentConditionsDisplay;
import org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer.DataLogger;
import org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.observer.Observer;
import org.eddydashcode.java_design_patterns.behavioral.observer.weather_station.subject.WeatherStation;

public class ClientApplication {
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        Observer display = new CurrentConditionsDisplay();
        Observer logger = new DataLogger();

        weatherStation.registerObserver(display);
        weatherStation.registerObserver(logger);

        weatherStation.setMeasurements(25.5f, 60f, 1012f);
        System.out.println(); // for spacing
        weatherStation.setMeasurements(27.3f, 55f, 1010f);
    }
}
