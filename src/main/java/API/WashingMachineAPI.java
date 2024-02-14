package API;

import entity.device.Documentation;
import entity.device.WashingMachine;
import States.TurnedOnState;

/**
 * Provides an API for controlling a washing machine.
 */
public class WashingMachineAPI {
    private WashingMachine washingMachine;

    /**
     * Constructs a WashingMachineAPI object.
     *
     * @param washingMachine the WashingMachine instance to control
     */
    public WashingMachineAPI(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    /**
     * Turns on the washing machine.
     */
    public void turnOn() {
        washingMachine.turnOn();
    }

    /**
     * Turns off the washing machine.
     */
    public void turnOff() {
        washingMachine.turnOff();
    }

    /**
     * Starts washing clothes if the washing machine is turned on.
     */
    public void washClothes() {
        if (washingMachine.getActivityState() instanceof TurnedOnState) {
            washingMachine.washClothes();
        } else {
            System.out.println("Device is not turned on");
        }
    }

    /**
     * Fixes the washing machine.
     *
     * @param documentation the documentation needed to fix the washing machine
     */
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing Washing Machine");
        washingMachine.fixDevice();
    }

    /**
     * Retrieves the documentation for the washing machine.
     *
     * @return the documentation for the washing machine
     */
    public Documentation getDocumentation() {
        return washingMachine.getDocumentation();
    }
}
