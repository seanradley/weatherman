package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;
import au.com.commbank.weatherman.WeatherReportGenerator;
import au.com.commbank.weatherman.WeatherStation;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RandomisedModifierTest {

    @Test
    public void testRandomisedTemperatureModifier() throws Exception {
        List<WeatherReport> reports = setupReports();

        assertNotEquals(reports.get(0).getTemperature(), reports.get(1).getTemperature());
    }

    @Test
    public void testRandomisedHumidityModifier() throws Exception {
        List<WeatherReport> reports = setupReports();

        assertNotEquals(reports.get(0).getHumidity(), reports.get(1).getHumidity());

    }

    private List<WeatherReport> setupReports() {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21);
        WeatherStation sydney2 = new WeatherStation("SYD", -33.86, 151.21);
        stations.add(sydney);
        stations.add(sydney2);

        ArrayList<WeatherModifier> weatherModifiers = new ArrayList<>();
        weatherModifiers.add(new RandomisedModifier());
        WeatherReportGenerator weatherReportGenerator = new WeatherReportGenerator(weatherModifiers);

        return weatherReportGenerator.generate(stations, LocalDateTime.now());
    }
}