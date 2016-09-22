package au.com.commbank.weatherman;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherReportGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21);
        stations.add(sydney);

        WeatherReportGenerator weatherReportGenerator = WeatherReportGenerator.createGeneratorWithAllModifiers();
        List<WeatherReport> reports = weatherReportGenerator.generate(stations, LocalDateTime.now());

        assertTrue(stations.size() == reports.size());
    }

}