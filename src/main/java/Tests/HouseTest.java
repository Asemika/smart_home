package Tests;


import entity.device.Light;
import entity.sensor.BackupGenerator;
import house.Floor;
import house.House;
import org.junit.jupiter.api.Test;
import systems.FireSystem;
import systems.WaterLeakSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HouseTest {

    @Test
    void testAddFloor() {
        House house = new House();
        Floor floor = new Floor();
        house.addFloor(floor);
        assertEquals(1, house.getFloors().size());
        assertEquals(floor, house.getFloors().get(0));
    }

    @Test
    void testSystemsInitialization() {
        House house = new House();
        assertNotNull(house.getLightSystem());
        assertNotNull(house.getFireSystem());
        assertNotNull(house.getWaterLeakSystem());
        assertEquals(Light.class, house.getLightSystem().getClass());
        assertEquals(FireSystem.class, house.getFireSystem().getClass());
        assertEquals(WaterLeakSystem.class, house.getWaterLeakSystem().getClass());
    }
}