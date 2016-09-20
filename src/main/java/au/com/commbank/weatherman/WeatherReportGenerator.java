package au.com.commbank.weatherman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherReportGenerator {
    public List<WeatherReport> generate(List<WeatherStation> stations) {
        ArrayList<WeatherReport> weatherReports = new ArrayList<>();

        for (WeatherStation station : stations) {
            WeatherReport report = WeatherReport.createBaseWeatherReport(station, LocalDateTime.now());
            applyModifiers(report);
            weatherReports.add(report);
        }

        return weatherReports;
    }

    private void applyModifiers(WeatherReport report) {
        applyLatitudeModifier(report);
    }

    private void applyLatitudeModifier(WeatherReport report) {
        /*
            30 deg at 0
            0 deg at 66.53 (Arctic Circle)
            30 / 66.56 = 0.45
         */
        double avgTempAtEquator = 30.0;
        double arcticCircleLatitude = 66.56;
        double tempDeltaPerLatitudinalDegree = avgTempAtEquator / arcticCircleLatitude;
        double avgTempLatitude = arcticCircleLatitude / 2.0;

        double deltaFromAvgTempLatitude = avgTempLatitude - Math.abs(report.getWeatherStation().getLatitude());
        double temperatureDelta = deltaFromAvgTempLatitude * tempDeltaPerLatitudinalDegree;
        report.setTemperature(report.getTemperature() + temperatureDelta);


    }
}
