package au.com.commbank.weatherman;

import java.util.List;

public class ConsoleEmitter {
    public void emitReports(List<WeatherReport> reports, WeatherReportFormatter weatherReportFormatter) {

        for (WeatherReport report : reports) {
            System.out.println(weatherReportFormatter.format(report));
        }
    }

    public void emitError(String message) {
        System.out.println("An error occurred: " + message);
    }
}
