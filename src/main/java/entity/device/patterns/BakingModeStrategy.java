package entity.device.patterns;

import entity.device.Oven;
import entity.device.interfaces.OvenModeStrategy;

public class BakingModeStrategy implements OvenModeStrategy {

    @Override
    public void execute(Oven oven) {
        System.out.println(oven.getName() + " is now in baking mode.");
    }
}
