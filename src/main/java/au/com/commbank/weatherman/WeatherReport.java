package au.com.commbank.weatherman;

import java.time.LocalDateTime;

public class WeatherReport {

    private String weatherStationIATACode;
    private String weatherStationCoordinates;
    private int elevation;
    private LocalDateTime dateTime;
    private WeatherConditions weatherConditions;
    private double temperature;
    private double pressure;
    private int humidity;

    public String getWeatherStationIATACode() {
        return weatherStationIATACode;
    }

    public void setWeatherStationIATACode(String weatherStationIATACode) {
        this.weatherStationIATACode = weatherStationIATACode;
    }

    public String getWeatherStationCoordinates() {
        return weatherStationCoordinates;
    }

    public void setWeatherStationCoordinates(String weatherStationCoordinates) {
        this.weatherStationCoordinates = weatherStationCoordinates;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
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
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
