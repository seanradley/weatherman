package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;

public class LatitudeModifier implements WeatherModifier {

    public static final double AVG_TEMP_AT_EQUATOR = 30.0;
    public static final double ARCTIC_CIRCLE_LATITUDE = 66.56;

    @Override
    public void applyModifier(WeatherReport report) {
        modifyTemperature(report);

    }

    private void modifyTemperature(WeatherReport report) {
        double tempDeltaPerLatitudinalDegree = AVG_TEMP_AT_EQUATOR / ARCTIC_CIRCLE_LATITUDE;
        double avgTempLatitude = ARCTIC_CIRCLE_LATITUDE / 2.0;

        double deltaFromAvgTempLatitude = avgTempLatitude - Math.abs(report.getWeatherStation().getLatitude());
        double temperatureDelta = deltaFromAvgTempLatitude * tempDeltaPerLatitudinalDegree;

        report.setTemperature(report.getTemperature() + temperatureDelta);
    }
}