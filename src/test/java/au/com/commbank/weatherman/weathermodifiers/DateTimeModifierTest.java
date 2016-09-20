package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;
import au.com.commbank.weatherman.WeatherReportGenerator;
import au.com.commbank.weatherman.WeatherStation;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DateTimeModifierTest {

    @Test
    public void testTimeOfDayTemperatureModifier() throws Exception {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21, 39);
        stations.add(sydney);

        WeatherReportGenerator weatherReportGenerator = WeatherReportGenerator.createGeneratorWithAllModifiers();
        WeatherReport report1540 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 15, 40)).get(0);
        WeatherReport report1550 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 15, 50)).get(0);
        WeatherReport report16 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 16, 0)).get(0);
        WeatherReport report1610 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 16, 10)).get(0);
        WeatherReport report1620 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 16, 20)).get(0);
        
        WeatherReport report340 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 3, 40)).get(0);
        WeatherReport report350 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 3, 50)).get(0);
        WeatherReport report4 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 4, 0)).get(0);
        WeatherReport report410 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 4, 10)).get(0);
        WeatherReport report420 = weatherReportGenerator.generate(stations, LocalDateTime.of(2016, 9, 20, 4, 20)).get(0);

        assertTrue(report1550.getTemperature() > report1540.getTemperature());
        assertTrue(report16.getTemperature() > report1550.getTemperature());
        assertTrue(report16.getTemperature() > report1610.getTemperature());
        assertTrue(report1610.getTemperature() > report1620.getTemperature());
        
        assertTrue(report340.getTemperature() < report350.getTemperature());
        assertTrue(report350.getTemperature() < report4.getTemperature());
        assertTrue(report4.getTemperature() < report410.getTemperature());
        assertTrue(report410.getTemperature() < report420.getTemperature());
    }

}