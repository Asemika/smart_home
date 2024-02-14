package API;

import entity.device.Documentation;
import house.Room;
import systems.LightSystem;

/**
 * Provides an API for controlling lights in a room.
 */
public class LightAPI implements FixAPI {
    LightSystem lightSystem;

    /**
     * Constructs a LightAPI object.
     *
     * @param lightSystem the LightSystem instance to control the lights
     */
    public LightAPI(LightSystem lightSystem){
        this.lightSystem = lightSystem;
    }

    /**
     * Turns on the lights in a specific room.
     *
     * @param room the room where the lights should be turned on
     */
    public void turnOn(Room room) {
        lightSystem.turnLightOn(room);
    }

    /**
     * Turns off the lights in a specific room.
     *
     * @param room the room where the lights should be turned off
     */
    public void turnOff(Room room) {
        lightSystem.turnLightOff(room);
    }

    /**
     * Fixes the light system.
     *
     * @param documentation the documentation needed to fix the light system
     */
    @Override
    public void fixDevice(Documentation documentation) {
        lightSystem.fixDevice();
    }
}
