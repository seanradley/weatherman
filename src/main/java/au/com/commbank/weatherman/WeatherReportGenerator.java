package au.com.commbank.weatherman;

import au.com.commbank.weatherman.weathermodifiers.DateTimeModifier;
import au.com.commbank.weatherman.weathermodifiers.LatitudeModifier;
import au.com.commbank.weatherman.weathermodifiers.WeatherModifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherReportGenerator {
    private List<WeatherModifier> modifiers;

    public WeatherReportGenerator(List<WeatherModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<WeatherReport> generate(List<WeatherStation> stations, LocalDateTime dateTime) {
        ArrayList<WeatherReport> weatherReports = new ArrayList<>();

        for (WeatherStation station : stations) {
            WeatherReport report = WeatherReport.createBaseWeatherReport(station, dateTime);
            applyModifiers(report);
            weatherReports.add(report);
        }

        return weatherReports;
    }

    private void applyModifiers(WeatherReport report) {
        for (WeatherModifier modifier : modifiers) {
            modifier.applyModifier(report);
        }
    }

    public static WeatherReportGenerator createGeneratorWithAllModifiers() {
        ArrayList<WeatherModifier> weatherModifiers = new ArrayList<>();
        weatherModifiers.add(new LatitudeModifier());
        weatherModifiers.add(new DateTimeModifier());

        WeatherReportGenerator generator = new WeatherReportGenerator(weatherModifiers);
        return generator;
    }
}
