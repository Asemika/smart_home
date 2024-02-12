package API;

import entity.device.Oven;

public interface OvenModeStrategy {
    void execute(Oven oven);
}
