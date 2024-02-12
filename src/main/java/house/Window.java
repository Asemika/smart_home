package house;

import entity.device.Blinds;
import entity.device.AirCondition;
import entity.device.DeviceType;

/**
 * Represents a window in a room.
 */
public class Window {
    private boolean isOpen;
    private boolean hasShutter;
    private Blinds blinds;

    /**
     * Constructs a window with or without a shutter.
     *
     * @param hasShutter true if the window has a shutter, false otherwise
     */
    public Window(boolean hasShutter) {
        this.isOpen = false;
        this.hasShutter = hasShutter;
        this.blinds = new Blinds("Living Room Blinds", DeviceType.BLINDS, 5.0, 2.0, 1.0);
    }

    /**
     * Constructs a window without a shutter.
     */
    public Window() {
        this(false);
    }

    /**
     * Checks if the window is open.
     *
     * @return true if the window is open, false otherwise
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Opens the window.
     */
    public void open() {
        isOpen = true;
        System.out.println("Window is now open.");
    }

    /**
     * Closes the window.
     */
    public void close() {
        isOpen = false;
        System.out.println("Window is now closed.");
    }

    /**
     * Checks if the window has a shutter.
     *
     * @return true if the window has a shutter, false otherwise
     */
    public boolean hasShutter() {
        return hasShutter;
    }

    /**
     * Gets the blinds associated with the window.
     *
     * @return the blinds object
     */
    public Blinds getBlinds() {
        return blinds;
    }

    /**
     * Closes the window if the air conditioner is turned on.
     */
    public void closeWindowsWhenAirConditionerOn() {
        AirCondition airCondition = new AirCondition("Living Room AC", DeviceType.AIR_CONDITION, 10.0, 5.0, 2.0);
        if (airCondition.isTurnedOn()) {
            close();
        }
    }

    /**
     * Opens the blinds associated with the window.
     */
    public void openBlinds() {
        blinds.open();
    }

    /**
     * Closes the blinds associated with the window when needed.
     * This method checks if the air conditioner is turned on, if it's night time, or if it's too sunny.
     */
    public void closeBlindsWhenNeeded() {
        AirCondition airCondition = new AirCondition("Living Room AC", DeviceType.AIR_CONDITION, 10.0, 5.0, 2.0);
        if (airCondition.isTurnedOn() || isNightTime() || isTooSunny()) {
            blinds.close();
        }
    }

    /**
     * Checks if it's night time.
     *
     * @return true if it's night time, false otherwise
     */
    private boolean isNightTime() {
        // Logic to determine night time
        return false; // Placeholder value
    }

    /**
     * Checks if it's too sunny.
     *
     * @return true if it's too sunny, false otherwise
     */
    private boolean isTooSunny() {
        // Logic to determine if it's too sunny
        return false; // Placeholder value
    }
}
