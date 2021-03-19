package be.pxl.ja.image;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GreyscalePixelTest {

    @Test
    public void compareToTest() {
        GrayscalePixel pixel1 = new GrayscalePixel(1);
        GrayscalePixel pixel2 = new GrayscalePixel(5);
        Assertions.assertEquals(-1, pixel1.compareTo(pixel2));
    }

    @Test
    public void distanceTest() {
        GrayscalePixel pixel1 = new GrayscalePixel(8);
        GrayscalePixel pixel2 = new GrayscalePixel(2);
        Assertions.assertEquals(6, pixel1.distance(pixel2));
    }
}
