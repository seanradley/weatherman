package au.com.commbank.weatherman;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeightMapReader {

    public static final int LATITUDE_RANGE = 180;
    public static final int LONGITUDE_RANGE = 360 - 1;
    public static final double ELEVATION_MULTIPLIER = 4.0;
    public static final String IMAGE_FILE_NAME = "elevation.bmp";
    private final BufferedImage image;

    public HeightMapReader() {
        try {
            image = readImage(IMAGE_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException("Could now load height map: " + IMAGE_FILE_NAME, e);
        }
    }

    public int getElevation(WeatherStation weatherStation) {
        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();

        int convertedLatitude = (int) Math.round((-weatherStation.getLatitude() + LATITUDE_RANGE / 2) / LATITUDE_RANGE * imageHeight);
        int convertedLongitude = (int) Math.round((weatherStation.getLongitude() + LONGITUDE_RANGE / 2) / LONGITUDE_RANGE * imageWidth);

        double height = getHeightATXY(convertedLongitude, convertedLatitude);
        return (int) (height * ELEVATION_MULTIPLIER);
    }

    private double getHeightATXY(int x, int y) {
        int clr = image.getRGB(x, y);
        int red = (clr & 0x00ff0000) >> 16;
        return red;
    }

    private BufferedImage readImage(String imageFileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File imageFile = new File(classLoader.getResource(imageFileName).getFile());

        BufferedImage image = ImageIO.read(imageFile);

        return image;
    }
}
