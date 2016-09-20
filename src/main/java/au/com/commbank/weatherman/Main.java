package au.com.commbank.weatherman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        stations.add(new WeatherStation("SYD", -33.86, 151.21, 39));
        stations.add(new WeatherStation("SIN", 1.359211,103.989306, 6));

        WeatherReportGenerator generator = WeatherReportGenerator.createGeneratorWithAllModifiers();
        List<WeatherReport> reports = generator.generate(stations, LocalDateTime.now());

        ConsoleEmitter consoleEmitter = new ConsoleEmitter();
        consoleEmitter.emitReports(reports, new WeatherReportFormatter());
    }
}
