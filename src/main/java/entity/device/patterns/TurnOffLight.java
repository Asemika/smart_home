package entity.device.patterns;

import entity.device.LightSystem;
import entity.device.interfaces.LightSystemState;

public class TurnOffLight implements LightSystemState {
    private final LightSystem lightSystem;

    public TurnOffLight(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    @Override
    public void turnOn() {
        lightSystem.setState(lightSystem.getTurnedOnState());
        System.out.println(lightSystem.getName() + " is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println(lightSystem.getName() + " is already turned off.");
    }

    @Override
    public void adjustBrightness(int brightness) {
        System.out.println(lightSystem.getName() + " is turned off. Please turn it on first.");
    }
}
