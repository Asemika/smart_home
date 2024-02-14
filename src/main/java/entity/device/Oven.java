package entity.device;

import java.util.List;

import java.util.List;

public class Oven extends Device {
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
