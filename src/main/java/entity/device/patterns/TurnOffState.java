package entity.device.patterns;

import entity.device.Fridge;
import entity.device.interfaces.FridgeState;

public class TurnOffState implements FridgeState {
    private final Fridge fridge;

    public TurnOffState(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the fridge.");
        fridge.setState(new TurnOnState(fridge));
    }

    @Override
    public void turnOff() {
        System.out.println("Fridge is already turned off.");
    }

    @Override
    public void open() {
        System.out.println("Cannot open the fridge. Fridge is turned off.");
    }

    @Override
    public void close() {
        System.out.println("Fridge is already closed.");
    }

    @Override
    public void orderFoodIfNeeded(int thresholdPercentage) {
        System.out.println("Cannot order food. Fridge is turned off.");
    }
}
