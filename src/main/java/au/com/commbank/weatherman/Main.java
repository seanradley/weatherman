package au.com.commbank.weatherman;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21, 39);
        stations.add(sydney);

        WeatherReportGenerator generator = WeatherReportGenerator.createGeneratorWithAllModifiers();
        List<WeatherReport> reports = generator.generate(stations);

        ConsoleEmitter consoleEmitter = new ConsoleEmitter();
        consoleEmitter.emitReports(reports, new WeatherReportFormatter());
    }
}
