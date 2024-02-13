package entity.device;
import entity.device.DeviceType;
public class Bicycle extends Device {
    private boolean isMoving;
    private int speed;
    private boolean isAtHome;
    private boolean areTiresInflated;
    private boolean isEquippedWithSensors;
    private boolean hasGPS;

    /**
     * Constructor for the Bicycle class.
     *
     * @param name                  The name of the bicycle.
     * @param isEquippedWithSensors Indicates if the bicycle is equipped with sensors.
     * @param hasGPS                Indicates if the bicycle has GPS.
     */
    public Bicycle(String name, boolean isEquippedWithSensors, boolean hasGPS) {
        super(name, DeviceType.BICYCLE, 0, 0, 0); // Assume zero consumption for simplicity
        this.isEquippedWithSensors = isEquippedWithSensors;
        this.hasGPS = hasGPS;
        this.isAtHome = true; // By default, the bicycle is considered to be at home
        this.areTiresInflated = true; // By default, we assume the tires are inflated
    }

    /**
     * Constructor for the Bicycle class.
     * This constructor initializes the bicycle without specifying its name or GPS status.
     *
     * @param isEquippedWithSensors Indicates if the bicycle is equipped with sensors.
     */
    public Bicycle(boolean isEquippedWithSensors) {
        super("", DeviceType.BICYCLE, 0, 0, 0); // Assume zero consumption for simplicity
        this.isEquippedWithSensors = isEquippedWithSensors;
        this.hasGPS = false; // Default value for GPS is false
        this.isAtHome = true; // By default, the bicycle is considered to be at home
        this.areTiresInflated = true; // By default, we assume the tires are inflated
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
        // Logic for bicycle usage
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

//    @Override
//    public Object getElectricityAPI() {
//        return null;
//    }
}
