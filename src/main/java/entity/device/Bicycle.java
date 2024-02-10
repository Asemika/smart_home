package entity.device;

public class Bicycle {
    private boolean isMoving;
    private int speed;
    private int batteryLevel;
    private boolean isEquippedWithSensors;
    private boolean hasGPS;
    private boolean isAtHome;
    private boolean areTiresInflated;

    /**
     * Constructor for the Bicycle class.
     *
     * @param isEquippedWithSensors Indicates if the bicycle is equipped with sensors.
     * @param hasGPS               Indicates if the bicycle has GPS.
     */
    public Bicycle(boolean isEquippedWithSensors, boolean hasGPS) {
        this.isEquippedWithSensors = isEquippedWithSensors;
        this.hasGPS = hasGPS;
        this.isAtHome = true; // By default, the bicycle is considered to be at home
        this.areTiresInflated = true; // By default, we assume the tires are inflated
        // Additional logic and initialization for integration with the smart home
    }

    /**
     * Starts the movement of the bicycle.
     */
    public void startMoving() {
        isMoving = true;
    }

    /**
     * Stops the movement of the bicycle.
     */
    public void stopMoving() {
        isMoving = false;
    }

    /**
     * Changes the speed of the bicycle.
     *
     * @param newSpeed The new speed.
     */
    public void changeSpeed(int newSpeed) {
        speed = newSpeed;
    }

    /**
     * Method indicating that the bicycle is being used.
     * This method may include sending data to the smart home or other actions.
     */
    public void rideBicycle() {

    }

    /**
     * Checks if the bicycle is equipped with sensors.
     *
     * @return true if the bicycle is equipped with sensors, false otherwise.
     */
    public boolean isEquippedWithSensors() {
        return isEquippedWithSensors;
    }

    /**
     * Checks if the bicycle has GPS.
     *
     * @return true if the bicycle has GPS, false otherwise.
     */
    public boolean hasGPS() {
        return hasGPS;
    }

    /**
     * Checks if the bicycle is at home.
     *
     * @return true if the bicycle is at home, false otherwise.
     */
    public boolean isAtHome() {
        return isAtHome;
    }

    /**
     * Checks if the tires of the bicycle are inflated.
     *
     * @return true if the tires are inflated, false otherwise.
     */
    public boolean areTiresInflated() {
        return areTiresInflated;
    }

    /**
     * Method for checking the overall status of the bicycle.
     */
    public void checkStatus() {
        System.out.println("Bicycle Status:");
        System.out.println("Is Moving: " + isMoving);
        System.out.println("Speed: " + speed);
        System.out.println("Battery Level: " + batteryLevel);
        System.out.println("Is At Home: " + isAtHome);
        System.out.println("Are Tires Inflated: " + areTiresInflated);
    }

    /**
     * Method for updating the tire status of the bicycle.
     *
     * @param inflated true if the tires are inflated, false otherwise.
     */
    public void updateTireStatus(boolean inflated) {
        areTiresInflated = inflated;
        System.out.println("Tire status updated. Are Tires Inflated: " + areTiresInflated);
    }
}
