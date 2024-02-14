package API;

import entity.device.Documentation;
import house.Room;
import systems.LightSystem;

public class LightAPI implements FixAPI {
    LightSystem lightSystem;

    public LightAPI(LightSystem lightSystem) {
        this.lightSystem= lightSystem;
    }

    public void turnOn(Room room) {
        lightSystem.turnLightOn(room);
    }

    public void turnOff(Room room) {
        lightSystem.turnLightOff(room);
    }

    @Override
    public void fixDevice(Documentation documentation) {
        lightSystem.fixDevice();
    }
}