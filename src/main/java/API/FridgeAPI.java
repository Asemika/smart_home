package API;

import entity.device.Documentation;
import entity.device.Fridge;

/**
 * The FridgeAPI class provides methods to interact with a fridge device.
 */
public class FridgeAPI implements FixAPI {
    private final Fridge fridge;

    /**
     * Constructs a new FridgeAPI with the specified fridge.
     *
     * @param fridge the fridge device to interact with
     */
    public FridgeAPI(Fridge fridge) {
        this.fridge = fridge;
    }

    /**
     * Turns on the fridge.
     */
    public void turnOn() {
        fridge.turnOn();
    }

    /**
     * Turns off the fridge.
     */
    public void turnOff() {
        fridge.turnOff();
    }

    /**
     * Fixes the fridge using the provided documentation.
     *
     * @param documentation the documentation used to fix the fridge
     */
    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing fridge");
        fridge.fixDevice();
    }

    /**
     * Gets the documentation related to the fridge.
     *
     * @return the documentation of the fridge
     */
    public Documentation getDocumentation() {
        return fridge.getDocumentation();
    }
}
