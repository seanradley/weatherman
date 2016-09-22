package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;
import au.com.commbank.weatherman.WeatherReportGenerator;
import au.com.commbank.weatherman.WeatherStation;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DateTimeModifierTest {

    private WeatherReportGenerator weatherReportGenerator;

    @Before
    public void setUp() throws Exception {
        ArrayList<WeatherModifier> weatherModifiers = new ArrayList<>();
        weatherModifiers.add(new DateTimeModifier());
        weatherReportGenerator = new WeatherReportGenerator(weatherModifiers);
    }

    @Test
    public void testTimeOfDayTemperatureModifier() throws Exception {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21);
        stations.add(sydney);

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

    @Test
    public void testSeasonalTemperatureModifier() throws Exception {
        ArrayList<WeatherStation> stations = new ArrayList<>();
        WeatherStation sydney = new WeatherStation("SYD", -33.86, 151.21);
        WeatherStation moscow = new WeatherStation("DME", 55.408611, 37.906111);
        stations.add(sydney);
        stations.add(moscow);

        List<WeatherReport> preJunSolstice = weatherReportGenerator.generate(stations,     LocalDateTime.of(2016, 5, 21, 15, 40));
        List<WeatherReport> junSolstice = weatherReportGenerator.generate(stations,        LocalDateTime.of(2016, 6, 21, 15, 40));
        List<WeatherReport> postJunSolstice = weatherReportGenerator.generate(stations,    LocalDateTime.of(2016, 7, 21, 15, 40));
        List<WeatherReport> preDecSolstice = weatherReportGenerator.generate(stations,     LocalDateTime.of(2016, 11, 22, 15, 40));
        List<WeatherReport> decSolstice = weatherReportGenerator.generate(stations,        LocalDateTime.of(2016, 12, 22, 15, 40));
        List<WeatherReport> postDecSolstice = weatherReportGenerator.generate(stations,    LocalDateTime.of(2017, 1, 22, 15, 40));

        assertTrue(junSolstice.get(0).getTemperature() < preJunSolstice.get(0).getTemperature());
        assertTrue(junSolstice.get(0).getTemperature() < postJunSolstice.get(0).getTemperature());
        assertTrue(decSolstice.get(0).getTemperature() > preDecSolstice.get(0).getTemperature());
        assertTrue(decSolstice.get(0).getTemperature() > postDecSolstice.get(0).getTemperature());

        assertTrue(junSolstice.get(1).getTemperature() > preJunSolstice.get(1).getTemperature());
        assertTrue(junSolstice.get(1).getTemperature() > postJunSolstice.get(1).getTemperature());
        assertTrue(decSolstice.get(1).getTemperature() < preDecSolstice.get(1).getTemperature());
        assertTrue(decSolstice.get(1).getTemperature() < postDecSolstice.get(1).getTemperature());
    }
}