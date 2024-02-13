package entity.device;

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
     * Closes blinds because of strong wind.
     *
     * @param event   The event that triggered the update
     * @param sensor  The sensor associated with the event
     */
    @Override
    public void update(Event event, WaterLeakSensor sensor) {
        if (EventType.STRONG_WIND.equals(event.getEventType())) {
            isOpened = false;
            System.out.println("Blinds are closed cuz of strong wind");
        }
    }

    @Override
    public void update(Event event, Fridge fridge) {

    }

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }


    @Override
    public void increaseTemp(int temp) {
        if (temp > 25) {
            open();
        } else {
            close();
        }
    }

    @Override
    public void decreaseTemp(int temp) {
        if (temp < 15) {
            open();
        } else {
            close();
        }
    }
}
