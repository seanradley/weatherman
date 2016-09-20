package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;

public interface WeatherModifier {
    void applyModifier(WeatherReport report);
}
