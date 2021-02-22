package be.pxl.ja.city;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityTest {
    @Test
    public void testDistanceLeuvenRoermond() {
        City leuven = new City("Leuven", 50.88151970000001, 4.6967578);
        City roermond = new City("Roermond", 51.19417, 5.9875);
        Assertions.assertEquals(96, leuven.distance(roermond), 1); //result found on internet, rounding is possible from 0.71
    }

    @Test
    public void testDistanceMaastrichtAken() {
        City maastricht = new City("Maastricht", 50.84833, 5.68889);
        City aken = new City("Aken", 50.77664, 6.08342);
        Assertions.assertEquals(28, maastricht.distance(aken), 1); //result found on internet
    }
}
