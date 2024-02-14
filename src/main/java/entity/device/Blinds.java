package entity.device;

import entity.sensor.Sensor;
import entity.sensor.WaterLeakSensor;
import event.Event;
import event.EventType;
import systems.WaterLeakSystem;

public class Blinds extends Device implements Observer, Open {
    private Boolean isOpened = false;

    public Boolean getOpened() {
        return isOpened;
    }

    public void setOpened(Boolean opened) {
        isOpened = opened;
    }

    public void open() {
        getElectricityAPI().increaseCounter(getkWPerHour());
        isOpened = true;
    }

    public void close() {
        getElectricityAPI().increaseCounter(getkWPerHour());
        isOpened = false;
    }

    /**
     * closes blinds because of strong wind.
     *
     * @param event
     * @param sensor
     */
    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType().equals(EventType.STRONG_WIND)) {
            isOpened = false;
            System.out.println("Blinds are closed cuz of strong wind");
        }
    }
}
