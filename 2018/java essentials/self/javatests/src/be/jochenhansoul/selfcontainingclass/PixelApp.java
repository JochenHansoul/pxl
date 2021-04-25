package be.jochenhansoul.selfcontainingclass;

public class PixelApp {
    public static void main(String[] args) {
        Pixel pixel = new Pixel((byte) 0, (byte) 0, (byte) 255);
        System.out.println(pixel.getValue());
    }
}
