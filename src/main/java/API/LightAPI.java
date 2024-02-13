package API;

public interface LightAPI {
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