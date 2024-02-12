package entity.device;

/**
 * This class represents smart blinds that can be controlled
 * to open or close based on certain conditions, such as light intensity.
 */
public abstract class Blinds extends Device {
    private boolean isOpen;

    // Assume this variable represents the current light intensity
    private int lightIntensity;

    /**
     * Constructs a new instance of {@code Blinds} with the specified parameters.
     *
     * @param name                the name of the blinds
     * @param type                the type of the blinds
     * @param activeConsumption   the power consumption when actively in use
     * @param idleConsumption     the power consumption when in idle state
     * @param turnedOffConsumption the power consumption when turned off
     */
    public Blinds(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isOpen = false;
    }

    /**
     * Checks if the blinds are currently open.
     *
     * @return true if the blinds are open, false otherwise
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Opens the blinds if they are not already open.
     */
    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println(getName() + " is now open.");
        } else {
            System.out.println(getName() + " is already open.");
        }
    }

    /**
     * Closes the blinds if they are not already closed.
     */
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println(getName() + " is now closed.");
        } else {
            System.out.println(getName() + " is already closed.");
        }
    }

    /**
     * Controls the blinds based on the specified light intensity threshold.
     * If the current light intensity is above the threshold, the blinds will open;
     * otherwise, they will close.
     *
     * @param lightIntensityThreshold the threshold for light intensity
     */
    public void controlBasedOnLightIntensity(int lightIntensityThreshold) {
        // Assume lightIntensity is a variable representing the current light intensity
        if (lightIntensity > lightIntensityThreshold) {
            open();
        } else {
            close();
        }
    }
}
