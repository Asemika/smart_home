package entity.device;

import house.Room;

/**
 * Represents a light system in a smart home.
 */
public class LightSystem extends Device {

    public LightSystem() {
    }

    public void turnLightOn(Room room) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        room.setLightIsOn(true);
    }

    public void turnLightOff(Room room) {
        room.setLightIsOn(false);
    }
}



// extends Device {
//    private LightSystemState turnedOnState;
//    private LightSystemState turnedOffState;
//    private LightSystemState state;
//    private int brightness;
//
//    /**
//     * Constructs a new `LightSystem` object.
//     */
//    public LightSystem(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
//        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
//        this.turnedOnState = (LightSystemState) new TurnOnLight(this);
//        this.turnedOffState = (LightSystemState) new TurnOffLight(this);
//        this.state = turnedOffState; // By default, the light system is turned off
//        this.brightness = 0; // Default brightness level
//    }
//
//    public LightSystem() {
//        super();
//    }
//
//    /**
//     * Sets the state of the light system.
//     *
//     * @param state The state of the light system.
//     */
//    public void setState(LightSystemState state) {
//        this.state = state;
//    }
//
//    /**
//     * Gets the turned on state of the light system.
//     *
//     * @return The turned on state of the light system.
//     */
//    public LightSystemState getTurnedOnState() {
//        return turnedOnState;
//    }
//
//    /**
//     * Gets the turned off state of the light system.
//     *
//     * @return The turned off state of the light system.
//     */
//    public LightSystemState getTurnedOffState() {
//        return turnedOffState;
//    }
//
//    /**
//     * Gets the brightness level of the light system.
//     *
//     * @return The brightness level of the light system.
//     */
//    public int getBrightness() {
//        return brightness;
//    }
//
//    /**
//     * Sets the brightness level of the light system.
//     *
//     * @param brightness The brightness level to set (percentage).
//     */
//    public void setBrightness(int brightness) {
//        this.brightness = Math.min(100, Math.max(0, brightness)); // Ensure brightness is between 0 and 100
//    }
//
//    /**
//     * Turns on the light system.
//     */
//    @Override
//    public void turnOn() {
//        state.turnOn();
//    }
//
//    /**
//     * Turns off the light system.
//     */
//    @Override
//    public void turnOff() {
//        state.turnOff();
//    }
//
//    @Override
//    public Object getElectricityAPI() {
//        return null;
//    }
//
//    /**
//     * Adjusts the brightness level of the light system.
//     *
//     * @param brightness The brightness level to set (percentage).
//     */
//    public void adjustBrightness(int brightness) {
//        state.adjustBrightness(brightness);
//    }
//}
