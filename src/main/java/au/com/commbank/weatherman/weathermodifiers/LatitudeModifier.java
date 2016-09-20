package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;

public class LatitudeModifier implements WeatherModifier {

    @Override
    public void applyModifier(WeatherReport report) {
        modifyTemperature(report);

    }

    private void modifyTemperature(WeatherReport report) {
        double avgTempAtEquator = 30.0;
        double arcticCircleLatitude = 66.56;
        double tempDeltaPerLatitudinalDegree = avgTempAtEquator / arcticCircleLatitude;
        double avgTempLatitude = arcticCircleLatitude / 2.0;

        double deltaFromAvgTempLatitude = avgTempLatitude - Math.abs(report.getWeatherStation().getLatitude());
        double temperatureDelta = deltaFromAvgTempLatitude * tempDeltaPerLatitudinalDegree;

        report.setTemperature(report.getTemperature() + temperatureDelta);
    }
}