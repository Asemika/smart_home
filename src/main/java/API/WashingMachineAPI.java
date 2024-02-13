package API;

import entity.device.Documentation;
import entity.device.WashingMachine;
import States.TurnedOnState;

public class WashingMachineAPI {
    private WashingMachine washingMachine;

    public WashingMachineAPI(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void turnOn() {
        washingMachine.turnOn();
    }

    public void turnOff() {
        washingMachine.turnOff();
    }

    public void washClothes() {
        if (washingMachine.getActivityState() instanceof TurnedOnState) {
            washingMachine.washClothes();
        } else {
            System.out.println("Device is not turned on");
        }
    }

    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing Washing Machine");
        washingMachine.fixDevice();
    }

    public Documentation getDocumentation() {
        return washingMachine.getDocumentation();
    }
}
