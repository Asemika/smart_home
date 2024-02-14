/**
 * Represents an oven device.
 * This class extends the Device class and provides functionality specific to an oven, such as baking food.
 */
package entity.device;

import java.util.List;

public class Oven extends Device {

    /**
     * Bakes food in the oven.
     * @param time The baking time in minutes.
     * @param ingredients The list of ingredients to be baked.
     * @return The baked food as a string.
     */
    public String bake(int time, List<String> ingredients) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        String bakedFood = "BAKED ";
        for (String ingredient : ingredients) {
            bakedFood += ingredient + " ,";
        }
        setUsageTime(getUsageTime() + time);
        ingredients.clear();
        return bakedFood;
    }
}