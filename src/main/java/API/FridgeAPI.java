package API;

import entity.device.Fridge;

public interface FridgeAPI {
    void turnOn();
    void turnOff();
    void open();
    void close();
    void setState(Fridge fridge);
    void orderFoodIfNeeded(int thresholdPercentage);
}
