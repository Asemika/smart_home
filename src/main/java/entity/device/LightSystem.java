package entity.device;

// Interface defining the states of the light system
interface LightSystemState {
    /**
     * Turns on the light system.
     */
    void turnOn();

    /**
     * Turns off the light system.
     */
    void turnOff();

    /**
     * Adjusts the brightness level of the light system.
     *
     * @param brightness The brightness level to set (percentage).
     */
    void adjustBrightness(int brightness);
}

// Concrete implementation of the light system in the turned on state
class TurnedOnState implements LightSystemState {
    private LightSystem lightSystem;

    public TurnedOnState(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    @Override
    public void turnOn() {
        System.out.println(lightSystem.getName() + " is already turned on.");
    }

    @Override
    public void turnOff() {
        lightSystem.setState(lightSystem.getTurnedOffState());
        System.out.println(lightSystem.getName() + " is turned off.");
    }

    @Override
    public void adjustBrightness(int brightness) {
        lightSystem.setBrightness(brightness);
        System.out.println(lightSystem.getName() + " brightness set to " + brightness + "%.");
    }
}

// Concrete implementation of the light system in the turned off state
class TurnedOffState implements LightSystemState {
    private LightSystem lightSystem;

    public TurnedOffState(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    @Override
    public void turnOn() {
        lightSystem.setState(lightSystem.getTurnedOnState());
        System.out.println(lightSystem.getName() + " is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println(lightSystem.getName() + " is already turned off.");
    }

    @Override
    public void adjustBrightness(int brightness) {
        System.out.println(lightSystem.getName() + " is turned off. Please turn it on first.");
    }
}

/**
 * Represents a light system in a smart home.
 */
public class LightSystem extends Device {
    private LightSystemState turnedOnState;
    private LightSystemState turnedOffState;
    private LightSystemState state;
    private int brightness;

    /**
     * Constructs a new `LightSystem` object.
     */
    public LightSystem() {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.turnedOnState = new TurnedOnState(this);
        this.turnedOffState = new TurnedOffState(this);
        this.state = turnedOffState; // By default, the light system is turned off
        this.brightness = 0; // Default brightness level
    }

    /**
     * Sets the state of the light system.
     *
     * @param state The state of the light system.
     */
    public void setState(LightSystemState state) {
        this.state = state;
    }

    /**
     * Gets the turned on state of the light system.
     *
     * @return The turned on state of the light system.
     */
    public LightSystemState getTurnedOnState() {
        return turnedOnState;
    }

    /**
     * Gets the turned off state of the light system.
     *
     * @return The turned off state of the light system.
     */
    public LightSystemState getTurnedOffState() {
        return turnedOffState;
    }

    /**
     * Gets the brightness level of the light system.
     *
     * @return The brightness level of the light system.
     */
    public int getBrightness() {
        return brightness;
    }

    /**
     * Sets the brightness level of the light system.
     *
     * @param brightness The brightness level to set (percentage).
     */
    public void setBrightness(int brightness) {
        this.brightness = Math.min(100, Math.max(0, brightness)); // Ensure brightness is between 0 and 100
    }

    /**
     * Turns on the light system.
     */
    @Override
    public void turnOn() {
        state.turnOn();
    }

    /**
     * Turns off the light system.
     */
    @Override
    public void turnOff() {
        state.turnOff();
    }

    /**
     * Adjusts the brightness level of the light system.
     *
     * @param brightness The brightness level to set (percentage).
     */
    public void adjustBrightness(int brightness) {
        state.adjustBrightness(brightness);
    }
}
