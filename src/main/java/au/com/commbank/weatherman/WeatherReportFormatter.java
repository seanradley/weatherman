package au.com.commbank.weatherman;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class WeatherReportFormatter {

    public static final String SEPARATOR = "|";

    public String format(WeatherReport weatherReport) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(weatherReport.getWeatherStation().getWeatherStationIATACode()).append(SEPARATOR);
        stringBuffer.append(weatherReport.getWeatherStation().getLatitude()).append(",")
                .append(weatherReport.getWeatherStation().getLongitude()).append(",")
                .append(weatherReport.getWeatherStation().getElevation()).append(SEPARATOR);
        stringBuffer.append(weatherReport.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))).append(SEPARATOR);
        stringBuffer.append(weatherReport.getWeatherConditions()).append(SEPARATOR);

        stringBuffer.append(weatherReport.getTemperature() >= 0 ? "+" : "");
        stringBuffer.append(new DecimalFormat("#.0").format(weatherReport.getTemperature())).append(SEPARATOR);

        stringBuffer.append(new DecimalFormat("#.0").format(weatherReport.getPressure())).append(SEPARATOR);
        stringBuffer.append(new DecimalFormat("#").format(weatherReport.getHumidity()));

        return stringBuffer.toString();
    }
}
