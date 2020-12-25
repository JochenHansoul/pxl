package be.pxl.examen.service;

import be.pxl.examen.model.Drone;
import be.pxl.examen.model.Droneclass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DroneClassTest {

    @Test
    public void testC0() {
        //fail("Write 2 relevant unit tests.");
        Drone drone1 = new Drone("", "", 1);
        Drone drone2 = new Drone("", "", 249);
        Assertions.assertEquals(drone1.getDroneclass(), Droneclass.C0);
        Assertions.assertEquals(drone2.getDroneclass(), Droneclass.C0);
    }

    @Test
    public void testC1() {
        Drone drone1 = new Drone("", "", 250);
        Drone drone2 = new Drone("", "", 3999);
        Assertions.assertEquals(drone1.getDroneclass(), Droneclass.C1);
        Assertions.assertEquals(drone2.getDroneclass(), Droneclass.C1);
    }
}
