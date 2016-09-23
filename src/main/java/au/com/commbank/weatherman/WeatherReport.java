package au.com.commbank.weatherman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherReport {

    private WeatherStation weatherStation;
    private LocalDateTime dateTime;
    private WeatherConditions weatherConditions;
    private double temperature;
    private int humidity;

    private WeatherReport() {

    }

    public static List<WeatherReport> createBaseWeatherReports(List<WeatherStation> weatherStations, LocalDateTime dateTime) {
        List<WeatherReport> baseWeatherReports = new ArrayList<>();

        HeightMapReader heightMapReader = new HeightMapReader();
        for (WeatherStation weatherStation : weatherStations) {
            WeatherReport baseWeatherReport = createBaseWeatherReport(weatherStation, dateTime, heightMapReader);

            baseWeatherReports.add(baseWeatherReport);
        }

        return baseWeatherReports;
    }

    public static WeatherReport createBaseWeatherReport(WeatherStation weatherStation, LocalDateTime dateTime, HeightMapReader heightMapReader) {
        WeatherReport baseWeatherReport = new WeatherReport();
        baseWeatherReport.setWeatherStation(weatherStation);
        baseWeatherReport.setDateTime(dateTime);
        baseWeatherReport.setWeatherConditions(WeatherConditions.Sun);
        baseWeatherReport.setTemperature(14.6);
        baseWeatherReport.setHumidity(75);

        baseWeatherReport.getWeatherStation().setElevation(heightMapReader.getElevation(weatherStation));
        return baseWeatherReport;
    }

    public WeatherStation getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public WeatherConditions getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(WeatherConditions weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return calculatePressure();
    }

    private double calculatePressure() {
        double pressureInPascal = 101325 * Math.pow(1 - (2.25577 * Math.pow(10, -5)) * weatherStation.getElevation(), 5.25588);
        double pressureInHectoPascal = pressureInPascal / 100.0;
        return pressureInHectoPascal;

    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
