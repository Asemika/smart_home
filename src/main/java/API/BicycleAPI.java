package API;

import entity.device.Bicycle;

public class BicycleAPI {
    private Bicycle bicycle;

    public BicycleAPI(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    /**
     * Initiates the movement of the bicycle.
     */
    public void startMoving() {
        bicycle.startMoving();
        System.out.println("Bicycle is now moving.");
    }

    /**
     * Stops the movement of the bicycle.
     */
    public void stopMoving() {
        bicycle.stopMoving();
        System.out.println("Bicycle has stopped moving.");
    }

    /**
     * Changes the speed of the bicycle.
     *
     * @param newSpeed The new speed.
     */
    public void changeSpeed(int newSpeed) {
        bicycle.changeSpeed(newSpeed);
        System.out.println("Bicycle speed is now set to: " + newSpeed);
    }

    /**
     * Calls the rideBicycle method of the bicycle.
     * This method may involve sending data to the smart home or other actions.
     */
    public void rideBicycle() {
        bicycle.rideBicycle();
        System.out.println("Bicycle is being used.");
    }

    /**
     * Checks the status of the bicycle and displays information.
     */
    public void checkBicycleStatus() {
        bicycle.checkStatus();
    }

    /**
     * Updates the tire status of the bicycle.
     *
     * @param inflated true if the tires are inflated, false otherwise.
     */
    public void updateTireStatus(boolean inflated) {
        bicycle.updateTireStatus(inflated);
    }

    /**
     * Checks if the bicycle is at home and displays information.
     */
    public void checkIfBicycleIsAtHome() {
        if (bicycle.isAtHome()) {
            System.out.println("Bicycle is at home.");
        } else {
            System.out.println("Bicycle is not at home.");
        }
    }

    /**
     * Checks if the bicycle is equipped with sensors and displays information.
     */
    public void checkIfBicycleIsEquippedWithSensors() {
        if (bicycle.isEquippedWithSensors()) {
            System.out.println("Bicycle is equipped with sensors.");
        } else {
            System.out.println("Bicycle is not equipped with sensors.");
        }
    }
}
