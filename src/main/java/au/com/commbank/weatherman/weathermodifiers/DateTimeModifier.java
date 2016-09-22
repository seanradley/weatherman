package au.com.commbank.weatherman.weathermodifiers;

import au.com.commbank.weatherman.WeatherReport;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateTimeModifier implements WeatherModifier {

    public static final double TEMP_DELTA_PER_HOUR = 10.0 / 12.0;
    public static final double TEMP_DELTA_PER_DAY = 25.0 / (30.0 * 6.0);

    @Override
    public void applyModifier(WeatherReport report) {
        applyTimeOfDayModifier(report);
        applySeasonalModifier(report);
    }

    private void applyTimeOfDayModifier(WeatherReport report) {
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

    private void applySeasonalModifier(WeatherReport report) {
        LocalDate junSolstice = LocalDate.now().withMonth(6).withDayOfMonth(21);
        LocalDate decSolstice = LocalDate.now().withMonth(12).withDayOfMonth(22);
        double hemisphereCorrector = report.getWeatherStation().getLatitude() > 0 ? -1 : 1;
        
        LocalDate reportDate = report.getDateTime().toLocalDate().withYear(junSolstice.getYear());

        if (reportDate.isAfter(junSolstice) && reportDate.isBefore(decSolstice)) {
            LocalDate sepEquinox = LocalDate.now().withMonth(9).withDayOfMonth(22);
            double daysDelta = DAYS.between(sepEquinox, reportDate);
            double tempDelta = daysDelta * TEMP_DELTA_PER_DAY;
            report.setTemperature(report.getTemperature() + (tempDelta * hemisphereCorrector));
        } else {
            if (reportDate.getMonthValue() == 12) {
                reportDate = reportDate.minusYears(1);
            }
            LocalDate marEquinox = LocalDate.now().withMonth(3).withDayOfMonth(20);
            double daysDelta = DAYS.between(marEquinox, reportDate);
            double tempDelta = daysDelta * TEMP_DELTA_PER_DAY;
            report.setTemperature(report.getTemperature() - (tempDelta * hemisphereCorrector));
        }
    }
}