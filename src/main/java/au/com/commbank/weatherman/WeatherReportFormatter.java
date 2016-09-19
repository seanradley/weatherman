package au.com.commbank.weatherman;

import java.time.format.DateTimeFormatter;

public class WeatherReportFormatter {

    public static final String SEPARATOR = "|";

    public String format(WeatherReport weatherReport) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(weatherReport.getWeatherStationIATACode()).append(SEPARATOR);
        stringBuffer.append(weatherReport.getWeatherStationCoordinates()).append(",").append(weatherReport.getElevation()).append(SEPARATOR);
        stringBuffer.append(weatherReport.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))).append(SEPARATOR);
        stringBuffer.append(weatherReport.getWeatherConditions()).append(SEPARATOR);

        stringBuffer.append( weatherReport.getTemperature() >= 0 ? "+" : "");
        stringBuffer.append(weatherReport.getTemperature()).append(SEPARATOR);

        stringBuffer.append(weatherReport.getPressure()).append(SEPARATOR);
        stringBuffer.append(weatherReport.getHumidity());

        return stringBuffer.toString();
    }
}
