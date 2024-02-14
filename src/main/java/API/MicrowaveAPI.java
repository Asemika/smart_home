package API;

import entity.device.Documentation;
import entity.device.Microwave;
import States.TurnedOnState;

/**
 * Provides an API for controlling a microwave.
 */
public class MicrowaveAPI implements FixAPI {
    Microwave microwave;

    /**
     * Constructs a MicrowaveAPI object.
     *
     * @param microwave the Microwave instance to control
     */
    public MicrowaveAPI(Microwave microwave) {
        this.microwave = microwave;
    }

    /**
     * Turns on the microwave.
     */
    public void turnOn() {
        microwave.turnOn();
    }

    /**
     * Turns off the microwave.
     */
    public void turnOff() {
        microwave.turnOff();
    }

    /**
     * Fixes the microwave.
     *
     * @param documentation the documentation needed to fix the microwave
     */
    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing microwave");
        microwave.fixDevice();
    }

    /**
     * Retrieves the documentation for the microwave.
     *
     * @return the documentation for the microwave
     */
    public Documentation getDocumentation() {
        return microwave.getDocumentation();
    }
}
