package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherConditions;
import au.com.commbank.weatherman.WeatherReport;

public class RandomisedModifier implements WeatherModifier {

    public static final double TEMPERATURE_SCALAR = 0.3;
    private static final double HUMIDITY_SCALAR = 0.2;

    @Override
    public void applyModifier(WeatherReport report) {
        modifyTemperature(report);
        modifyHumidity(report);
        modifyConditions(report);
    }

    private void modifyTemperature(WeatherReport report) {
        double random = Math.random() * 2 - 1;
        double tempDelta = random * TEMPERATURE_SCALAR * report.getTemperature();

        report.setTemperature(report.getTemperature() + tempDelta);
    }

    private void modifyHumidity(WeatherReport report) {
        double random = Math.random() * 2 - 1;
        double humidityDelta = random * HUMIDITY_SCALAR * report.getHumidity();

        report.setHumidity((int) (report.getHumidity() + humidityDelta));
    }

    private void modifyConditions(WeatherReport report) {
        double random = Math.random();

        boolean isPrecipitation = report.getHumidity() > 85 && random > 0.5;
        if (isPrecipitation) {
            if (report.getTemperature() > 2.0) {
                report.setWeatherConditions(WeatherConditions.Rain);
            } else {
                report.setWeatherConditions(WeatherConditions.Snow);
            }
        } else if (report.getHumidity() > 80) {
            report.setWeatherConditions(WeatherConditions.Cloud);
        }
    }
}