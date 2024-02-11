package entity.device.interfaces;

import entity.device.Fridge;

public interface FridgeState {
    void turnOn();
    void turnOff();
    void open();
    void close();
    void setState(Fridge fridge);
    void orderFoodIfNeeded(int thresholdPercentage);
}

