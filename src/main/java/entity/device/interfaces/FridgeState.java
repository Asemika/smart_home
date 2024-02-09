package entity.device.interfaces;

public interface FridgeState {
    void turnOn();

    void turnOff();

    void open();

    void close();

    void orderFoodIfNeeded(int thresholdPercentage);
}
