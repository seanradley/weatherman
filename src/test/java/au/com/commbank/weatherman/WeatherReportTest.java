package au.com.commbank.weatherman;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class WeatherReportTest {
    @Test
    public void testCreateBaseWeatherReport() throws Exception {
        WeatherReport baseWeatherReport = WeatherReport.createBaseWeatherReport(new WeatherStation("SYD", -33.86, 151.21), LocalDateTime.now(), new HeightMapReader());

        assertNotNull(baseWeatherReport.getWeatherStation().getWeatherStationIATACode());
        assertNotNull(baseWeatherReport.getWeatherStation().getLatitude());
        assertNotNull(baseWeatherReport.getWeatherStation().getLongitude());
        assertNotNull(baseWeatherReport.getWeatherStation().getElevation());

        assertNotNull(baseWeatherReport.getDateTime());
        assertNotNull(baseWeatherReport.getHumidity());
        assertNotNull(baseWeatherReport.getTemperature());
        assertNotNull(baseWeatherReport.getPressure());
        assertNotNull(baseWeatherReport.getWeatherConditions());
    }

}