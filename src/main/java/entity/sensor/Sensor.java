package entity.sensor;

import entity.device.Observer;
import event.Event;
import systems.WaterLeakSystem;

public abstract class Sensor {
    private SensorType type;
    private boolean isWorking;

    public Sensor(SensorType type) {
        this.type = type;
        this.isWorking = true;
    }

    public SensorType getType() {
        return type;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public abstract void attach(Observer observer);

    public abstract void detach(Observer observer);

    public void notifyAllObservers(Event event) {
    }

    public abstract void notifySystem();

    public abstract void attach(WaterLeakSystem waterLeakSystem);

    public abstract void turnOn();

    public abstract void increaseTemp(int temp);

    public abstract void decreaseTemp(int temp);
}
