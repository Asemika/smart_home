package entity.device.patterns;

import entity.device.LightSystem;
import entity.device.interfaces.LightSystemState;

public class TurnOnLight implements LightSystemState {
    private final LightSystem lightSystem;

    public TurnOnLight(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    @Override
    public void turnOn() {
        System.out.println(lightSystem.getName() + " is already turned on.");
    }

    @Override
    public void turnOff() {
        lightSystem.setState(lightSystem.getTurnedOffState());
        System.out.println(lightSystem.getName() + " is turned off.");
    }

    @Override
    public void adjustBrightness(int brightness) {
        lightSystem.setBrightness(brightness);
        System.out.println(lightSystem.getName() + " brightness set to " + brightness + "%.");
    }
}