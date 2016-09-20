package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;

public class DateTimeModifier implements WeatherModifier {

    public static final double TEMP_DELTA_PER_HOUR = 10.0 / 12.0;

    @Override
    public void applyModifier(WeatherReport report) {
        double hour = report.getDateTime().getHour();
        double minute = report.getDateTime().getMinute();

        double timeOfDayDecimal = hour + minute / 60;
        double tempDelta;

        if (timeOfDayDecimal >= 0.0 && timeOfDayDecimal < 16.0) {
            double timeDelta = timeOfDayDecimal - 4.0;
            tempDelta = timeDelta * TEMP_DELTA_PER_HOUR;
            double tempAt4am = report.getTemperature() - 6 * TEMP_DELTA_PER_HOUR;
            report.setTemperature(tempAt4am + tempDelta);
        } else {
            double timeDelta = 16.0 - timeOfDayDecimal;
            tempDelta = timeDelta * TEMP_DELTA_PER_HOUR;
            double tempAt4pm = report.getTemperature() + 6 * TEMP_DELTA_PER_HOUR;
            report.setTemperature(tempAt4pm + tempDelta);
        }
    }
}


/*
|-------------------------------------------------|
0       4           10     12       16           2359
 */