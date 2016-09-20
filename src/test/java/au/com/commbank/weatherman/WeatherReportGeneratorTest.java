package au.com.commbank.weatherman;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WeatherReportGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        WeatherReportGenerator weatherReportGenerator = new WeatherReportGenerator();
        List<WeatherReport> reports = weatherReportGenerator.generate();

        assertTrue(1 <= reports.size());
    }

}