package be.pxl.ja.image;

import be.pxl.ja.common.DistanceFunction;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class GrayscalePixel implements PixelToInt, Comparable<GrayscalePixel>, DistanceFunction<GrayscalePixel> {
    private int greyscale; //int met 3x zelfde waarde?

    public GrayscalePixel(int greyscale) {
        this.greyscale = greyscale;
    }

    public int getGreyscale() {
        return greyscale;
    }

    @Override
    public int toRGB() {
        return new Color(greyscale, greyscale, greyscale).getRGB();
    }

    @Override
    public String toString() {
        return Integer.toString(greyscale);
    }

    @Override
    public int compareTo(GrayscalePixel o) {
        return Integer.compare(this.getGreyscale(), o.getGreyscale());
    }

    @Override
    public double distance(GrayscalePixel pixel) {
        //absolute waarde verschil greyscale waarden
        int number = this.greyscale - pixel.greyscale;
        if (number < 0) {
            return number * -1;
        }
        return number; // 2 - 10 = -8 --> 8
    }
}
