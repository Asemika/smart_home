package entity.device.patterns;

import entity.device.Fridge;
import entity.device.interfaces.FridgeState;

public class TurnOnState implements FridgeState {
    private final Fridge fridge;

    public TurnOnState(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    public void turnOn() {
        System.out.println("Fridge is already turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the fridge.");
        fridge.setState(new TurnOffState(fridge));
    }

    @Override
    public void open() {
        System.out.println("Fridge is now open.");
    }

    @Override
    public void close() {
        System.out.println("Please close the fridge before turning it off.");
    }

    @Override
    public void orderFoodIfNeeded(int thresholdPercentage) {
        int foodPercentage = fridge.getFoodPercentage();
        if (foodPercentage < thresholdPercentage) {
            System.out.println("Food percentage is low. Ordering more food...");
        } else {
            System.out.println("Food percentage is sufficient. No need to order.");
        }
    }
}
