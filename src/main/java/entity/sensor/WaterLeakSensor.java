package entity.sensor;

import house.Room;
import systems.WaterLeakSystem;

public class WaterLeakSensor extends Sensor {
    private boolean isLeakDetected;
    private Room room;

    public WaterLeakSensor() {
        super(SensorType.WATER_LEAK);
        this.room = room;
        this.isLeakDetected = false;
    }


    public void detectLeak() {
        isLeakDetected = true;
    }

    public boolean isLeakDetected() {
        return isLeakDetected;
    }

    @Override
    public void notifySystem() {
        if (isLeakDetected()) {
            System.out.println("Water leak detected in " + room.getName() + "! Notifying the system.");
        }
    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void turnOn() {

    }

    public void reset() {
        isLeakDetected = false;
    }
}
