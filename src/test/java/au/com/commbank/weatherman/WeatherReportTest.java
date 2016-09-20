package au.com.commbank.weatherman;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class WeatherReportTest {
    @Test
    public void testCreateBaseWeatherReport() throws Exception {
        WeatherReport baseWeatherReport = WeatherReport.createBaseWeatherReport("SYD", -33.86, 151.21, 39, LocalDateTime.now());

        assertNotNull(baseWeatherReport.getWeatherStationIATACode());
        assertNotNull(baseWeatherReport.getLatitude());
        assertNotNull(baseWeatherReport.getLongitude());
        assertNotNull(baseWeatherReport.getElevation());

        assertNotNull(baseWeatherReport.getDateTime());
        assertNotNull(baseWeatherReport.getHumidity());
        assertNotNull(baseWeatherReport.getTemperature());
        assertNotNull(baseWeatherReport.getPressure());
        assertNotNull(baseWeatherReport.getWeatherConditions());
    }

}