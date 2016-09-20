package au.com.commbank.weatherman;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WeatherReportGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21, 39);
        stations.add(sydney);

        WeatherReportGenerator weatherReportGenerator = WeatherReportGenerator.createGeneratorWithAllModifiers();
        List<WeatherReport> reports = weatherReportGenerator.generate(stations);

        assertTrue(1 == reports.size());
    }

    @Test
    public void testLatitudeTemperatureModifier() throws Exception {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21, 39);
        WeatherStation equator = new WeatherStation("SYD", 0, 151.21, 39);
        WeatherStation northPole = new WeatherStation("SYD", 90, 151.21, 39);
        WeatherStation arcticCircle = new WeatherStation("SYD", 66.53, 151.21, 39);
        WeatherStation capricorn = new WeatherStation("SYD", -23.43712, 151.21, 39);
        WeatherStation cancer = new WeatherStation("SYD", -23.43712, 151.21, 39);
        stations.add(sydney);
        stations.add(equator);
        stations.add(northPole);
        stations.add(arcticCircle);
        stations.add(capricorn);
        stations.add(cancer);

        WeatherReportGenerator weatherReportGenerator = WeatherReportGenerator.createGeneratorWithAllModifiers();
        List<WeatherReport> reports = weatherReportGenerator.generate(stations);

        assertTrue(reports.get(0).getTemperature() < reports.get(1).getTemperature());
        assertTrue(reports.get(0).getTemperature() > reports.get(2).getTemperature());
        assertTrue(reports.get(0).getTemperature() > reports.get(3).getTemperature());
        assertTrue(reports.get(0).getTemperature() < reports.get(4).getTemperature());
        assertTrue(reports.get(0).getTemperature() < reports.get(5).getTemperature());
    }

}