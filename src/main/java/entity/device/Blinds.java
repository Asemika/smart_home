package entity.device;

import entity.device.Device;
import entity.device.Observer;
import entity.device.Open;
import entity.sensor.Sensor;
import event.Event;

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
        if (event.getEventType() == EventType.STRONG_WIND) {
            isOpened = false;
            System.out.println("Blinds are closed cuz of strong wind");
        }
    }

    @Override
    public void update(Event event, Sensor sensor) {

    }
}