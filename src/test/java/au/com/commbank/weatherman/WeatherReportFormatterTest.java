package au.com.commbank.weatherman;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;

public class WeatherReportFormatterTest {

    @Test
    public void testEmitterOutput() {
        WeatherReportFormatter weatherReportFormatter = new WeatherReportFormatter();

        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setWeatherStationIATACode("SYD");
        weatherReport.setWeatherStationCoordinates("-33.86,151.21");
        weatherReport.setElevation(39);
        weatherReport.setDateTime(LocalDateTime.of(2015, 12, 23, 5, 2, 12));
        weatherReport.setWeatherConditions(WeatherConditions.Rain);
        weatherReport.setTemperature(12.5);
        weatherReport.setPressure(1004.3);
        weatherReport.setHumidity(97);

        String formattedReport = weatherReportFormatter.format(weatherReport);
        assertEquals("SYD|-33.86,151.21,39|2015-12-23T05:02:12Z|Rain|+12.5|1004.3|97", formattedReport);
    }

}
