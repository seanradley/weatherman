package au.com.commbank.weatherman;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;

public class WeatherReportFormatterTest {

    @Test
    public void testFormatterOutput() throws Exception {
        WeatherReportFormatter weatherReportFormatter = new WeatherReportFormatter();

        WeatherReport weatherReport = WeatherReport.createBaseWeatherReport(new WeatherStation("SYD", -33.86, 151.21), LocalDateTime.of(2015, 12, 23, 5, 2, 12), new HeightMapReader());
        weatherReport.getWeatherStation().setElevation(39);
        weatherReport.setWeatherConditions(WeatherConditions.Sun);
        weatherReport.setTemperature(12.5);
        weatherReport.setHumidity(97);

        String formattedReport = weatherReportFormatter.format(weatherReport);
        assertEquals("SYD|-33.86,151.21,39|2015-12-23T05:02:12Z|Sun|+12.5|1008.6|97", formattedReport);

        weatherReport.setTemperature(-12.5);
        formattedReport = weatherReportFormatter.format(weatherReport);
        assertEquals("SYD|-33.86,151.21,39|2015-12-23T05:02:12Z|Sun|-12.5|1008.6|97", formattedReport);

        weatherReport.getWeatherStation().setLatitude(-33.861234);
        weatherReport.getWeatherStation().setLongitude(151.2135678);
        formattedReport = weatherReportFormatter.format(weatherReport);
        assertEquals("SYD|-33.86,151.21,39|2015-12-23T05:02:12Z|Sun|-12.5|1008.6|97", formattedReport);
    }

}
