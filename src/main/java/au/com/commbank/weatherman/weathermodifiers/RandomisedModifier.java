package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;

public class RandomisedModifier implements WeatherModifier {

    public static final double TEMPERATURE_SCALAR = 0.3;
    private static final double HUMIDITY_SCALAR = 0.2;

    @Override
    public void applyModifier(WeatherReport report) {
        modifyTemperature(report);
        modifyHumidity(report);
    }

    private void modifyTemperature(WeatherReport report) {
        double random = Math.random() * 2 - 1;
        double tempDelta = random * TEMPERATURE_SCALAR * report.getTemperature();

        report.setTemperature(report.getTemperature() + tempDelta );
    }

    private void modifyHumidity(WeatherReport report) {
        double random = Math.random() * 2 - 1;
        double humidityDelta = random * HUMIDITY_SCALAR * report.getHumidity();

        report.setHumidity((int) (report.getHumidity() + humidityDelta));
    }
}