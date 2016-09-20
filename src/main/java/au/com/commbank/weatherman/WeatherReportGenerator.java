package au.com.commbank.weatherman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherReportGenerator {
    public List<WeatherReport> generate() {
        ArrayList<WeatherReport> weatherReports = new ArrayList<>();

        WeatherReport report = WeatherReport.createBaseWeatherReport("SYD", -33.86, 151.21, 39, LocalDateTime.now());
        weatherReports.add(report);

        return weatherReports;
    }
}
