package au.com.commbank.weatherman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeightMapReaderTest {

    private HeightMapReader heightMapReader;

    @Before
    public void setUp() throws Exception {
        heightMapReader = new HeightMapReader();
    }

    @Test
    public void testGetElevation() throws Exception {
        WeatherStation station = new WeatherStation("SYD", -33.946111, 151.177222);
        double elevation = heightMapReader.getElevation(station);
        assertEquals(4.0, elevation, 0.0);

        station = new WeatherStation("MEL", -37.83, 144.98);
        elevation = heightMapReader.getElevation(station);
        assertEquals(8.0, elevation, 0.0);
    }
}