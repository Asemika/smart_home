package entity.device.patterns;

import entity.device.interfaces.MicrowaveMode;

public class HeatingMode implements MicrowaveMode {
    @Override
    public void execute() {
        System.out.println("Microwave is now in heating mode.");
    }
}
