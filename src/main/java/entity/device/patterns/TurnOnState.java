package entity.device.patterns;

import entity.device.Fridge;
import entity.device.interfaces.FridgeState;

/**
 * Represents the state of the fridge when it is turned on.
 */
public class TurnOnState implements FridgeState {
    private final Fridge fridge;

    /**
     * Constructs a new TurnOnState object for the specified fridge.
     *
     * @param fridge The fridge object associated with this state.
     */
    public TurnOnState(Fridge fridge) {
        this.fridge = fridge;
    }

    /**
     * Turns on the fridge. Prints a message if the fridge is already turned on.
     */
    @Override
    public void turnOn() {
        System.out.println("Fridge is already turned on.");
    }

    /**
     * Turns off the fridge and changes its state to TurnOffState.
     */
    @Override
    public void turnOff() {
        System.out.println("Turning off the fridge.");
        fridge.setState(new TurnOffState(fridge));
    }

    /**
     * Opens the fridge.
     */
    @Override
    public void open() {
        System.out.println("Fridge is now open.");
    }

    /**
     * Closes the fridge.
     */
    @Override
    public void close() {
        System.out.println("Please close the fridge before turning it off.");
    }

    /**
     * Checks if food needs to be ordered based on the fridge's food percentage.
     *
     * @param thresholdPercentage The threshold food percentage below which food needs to be ordered.
     */
    @Override
    public void orderFoodIfNeeded(int thresholdPercentage) {
        int foodPercentage = fridge.getFoodPercentage();
        if (foodPercentage < thresholdPercentage) {
            System.out.println("Food percentage is low. Ordering more food...");
        } else {
            System.out.println("Food percentage is sufficient. No need to order.");
        }
    }

    /**
     * Sets the state of the fridge to TurnOnState.
     *
     * @param fridge The fridge object for which to set the state.
     */
    @Override
    public void setState(Fridge fridge) {
        // Setting the state to "turned on" for the fridge
        fridge.setState(new TurnOnState(fridge));
    }
}
