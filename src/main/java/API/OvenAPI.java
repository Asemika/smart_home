package API;

import entity.device.Documentation;
import entity.device.Oven;

/**
 * Provides an API for controlling an oven.
 */
public class OvenAPI implements FixAPI {
    Oven oven;

    /**
     * Constructs an OvenAPI object.
     *
     * @param oven the Oven instance to control
     */
    public OvenAPI(Oven oven) {
        this.oven = oven;
    }

    /**
     * Turns on the oven.
     */
    public void turnOn() {
        oven.turnOn();
    }

    /**
     * Turns off the oven.
     */
    public void turnOff() {
        oven.turnOff();
    }

    /**
     * Fixes the oven.
     *
     * @param documentation the documentation needed to fix the oven
     */
    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing oven");
        oven.fixDevice();
    }

    /**
     * Retrieves the documentation for the oven.
     *
     * @return the documentation for the oven
     */
    public Documentation getDocumentation() {
        return oven.getDocumentation();
    }
}
