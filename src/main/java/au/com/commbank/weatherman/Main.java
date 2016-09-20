package au.com.commbank.weatherman;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeatherReportGenerator generator = new WeatherReportGenerator();
        List<WeatherReport> reports = generator.generate();

        ConsoleEmitter consoleEmitter = new ConsoleEmitter();
        consoleEmitter.emitReports(reports, new WeatherReportFormatter());
    }
}
