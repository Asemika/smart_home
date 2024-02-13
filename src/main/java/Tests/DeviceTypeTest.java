package Tests;

import entity.device.DeviceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class DeviceTypeTest {

    private DeviceType deviceType;

    @BeforeEach
    void setup() {
        deviceType = null; // Resetujte instanci před každým testem
    }

    @Test
    void checkDeviceTypeTV() {
        deviceType = DeviceType.TV;
        assertEquals("TV", deviceType.toString());
    }

    @Test
    void checkDeviceTypeFridge() {
        deviceType = DeviceType.FRIDGE;
        assertEquals("FRIDGE", deviceType.toString());
    }

    @Test
    void checkDeviceTypeOven() {
        deviceType = DeviceType.OVEN;
        assertEquals("OVEN", deviceType.toString());
    }

    @Test
    void checkDeviceTypeMicrowave() {
        deviceType = DeviceType.MICROWAVE;
        assertEquals("MICROWAVE", deviceType.toString());
    }

    @Test
    void checkDeviceTypeWashingMachine() {
        deviceType = DeviceType.WASHING_MACHINE;
        assertEquals("WASHING_MACHINE", deviceType.toString());
    }

    @Test
    void checkDeviceTypeBlinds() {
        deviceType = DeviceType.BLINDS;
        assertEquals("BLINDS", deviceType.toString());
    }

    @Test
    void checkDeviceTypeAirConditioner() {
        deviceType = DeviceType.AIR_CONDITIONER;
        assertEquals("AIR_CONDITIONER", deviceType.toString());
    }

    @Test
    void checkDeviceTypeConstants() {
        assertEquals(DeviceType.AIR_CONDITION, DeviceType.AIR_CONDITIONER);
        assertEquals(DeviceType.BICYCLE, DeviceType.AIR_CONDITIONER);
    }
}