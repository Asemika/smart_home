package API;

import entity.device.Documentation;
import entity.device.Microwave;
import States.TurnedOnState;

public class MicrowaveAPI implements FixAPI {
    Microwave microwave;

    public MicrowaveAPI(Microwave microwave) {
        this.microwave = microwave;
    }

    public void turnOn() {
        microwave.turnOn();
    }

    public void turnOff() {
        microwave.turnOff();
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing microwave");
        microwave.fixDevice();
    }

    public Documentation getDocumentation() {
        return microwave.getDocumentation();
    }
}