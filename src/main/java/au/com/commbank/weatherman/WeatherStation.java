package au.com.commbank.weatherman;

public class WeatherStation {

    private String weatherStationIATACode;
    private double latitude;
    private double longitude;
    private int elevation;

    public WeatherStation(String weatherStationIATACode, double latitude, double longitude) {
        this.weatherStationIATACode = weatherStationIATACode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getWeatherStationIATACode() {
        return weatherStationIATACode;
    }

    public void setWeatherStationIATACode(String weatherStationIATACode) {
        this.weatherStationIATACode = weatherStationIATACode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }
}
