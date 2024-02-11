package entity.device.patterns;

import entity.device.Fridge;
import entity.device.interfaces.FridgeState;

/**
 * Represents the state of the fridge when it is turned off.
 */
public class TurnOffState implements FridgeState {
    private final Fridge fridge;

    /**
     * Constructs a new TurnOffState object for the specified fridge.
     *
     * @param fridge The fridge object associated with this state.
     */
    public TurnOffState(Fridge fridge) {
        this.fridge = fridge;
    }

    /**
     * Turns on the fridge and changes its state to TurnOnState.
     */
    @Override
    public void turnOn() {
        System.out.println("Turning on the fridge.");
        fridge.setState(new TurnOnState(fridge));
    }

    /**
     * Turns off the fridge. Prints a message if the fridge is already turned off.
     */
    @Override
    public void turnOff() {
        System.out.println("Fridge is already turned off.");
    }

    /**
     * Opens the fridge. Prints a message that the fridge cannot be opened when turned off.
     */
    @Override
    public void open() {
        System.out.println("Cannot open the fridge. Fridge is turned off.");
    }

    /**
     * Closes the fridge. Prints a message that the fridge is already closed.
     */
    @Override
    public void close() {
        System.out.println("Fridge is already closed.");
    }

    /**
     * Checks if food needs to be ordered. Prints a message that food cannot be ordered when the fridge is turned off.
     *
     * @param thresholdPercentage The threshold food percentage below which food needs to be ordered.
     */
    @Override
    public void orderFoodIfNeeded(int thresholdPercentage) {
        System.out.println("Cannot order food. Fridge is turned off.");
    }

    /**
     * Sets the state of the fridge to TurnOffState.
     *
     * @param fridge The fridge object for which to set the state.
     */
    @Override
    public void setState(Fridge fridge) {
        // Setting the state to "turned off" for the fridge
        fridge.setState(new TurnOffState(fridge));
    }
}
