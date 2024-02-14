/**
 * Represents a washing machine device.
 * This class extends the Device class and provides functionality specific to a washing machine, such as washing clothes.
 */
package entity.device;

import API.WaterAPI;

public class WashingMachine extends Device {
    private final WaterAPI waterAPI = new WaterAPI();

    /**
     * Washes clothes using the washing machine.
     * Increases the water and electricity usage counters.
     */
    public void washClothes() {
        waterAPI.increaseCounter(40);
        getElectricityAPI().increaseCounter(getkWPerHour());
    }

    /**
     * Gets the WaterAPI instance associated with the washing machine.
     * @return The WaterAPI instance.
     */
    public WaterAPI getWaterAPI() {
        return waterAPI;
    }
}
