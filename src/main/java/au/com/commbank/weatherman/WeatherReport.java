package au.com.commbank.weatherman;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class WeatherReport {

    private String weatherStationIATACode;
    private double latitude;
    private double longitude;
    private int elevation;
    private LocalDateTime dateTime;
    private WeatherConditions weatherConditions;
    private double temperature;
    private int humidity;

    private WeatherReport() {

    }

    public static WeatherReport createBaseWeatherReport(String stationIATACode, double latitude, double longitude, int elevation, LocalDateTime dateTime) {
        WeatherReport baseWeatherReport = new WeatherReport();
        baseWeatherReport.setWeatherStationIATACode(stationIATACode);
        baseWeatherReport.setLatitude(latitude);
        baseWeatherReport.setLongitude(longitude);
        baseWeatherReport.setElevation(elevation);
        baseWeatherReport.setDateTime(dateTime);
        baseWeatherReport.setWeatherConditions(WeatherConditions.Rain);
        baseWeatherReport.setTemperature(14.6);
        baseWeatherReport.setHumidity(97);

        return baseWeatherReport;
    }

    public String getWeatherStationIATACode() {
        return weatherStationIATACode;
    }

    public void setWeatherStationIATACode(String weatherStationIATACode) {
        this.weatherStationIATACode = weatherStationIATACode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        return calculatePressure();
    }

    private double calculatePressure() {
        double pressureInPascal = 101325 * Math.pow(1 - (2.25577 * Math.pow(10, -5)) * getElevation(), 5.25588);
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
