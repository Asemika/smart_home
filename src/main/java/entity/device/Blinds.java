package entity.device;

import entity.sensor.Sensor;
import entity.sensor.WaterLeakSensor;
import event.Event;
import event.EventType;
import systems.WaterLeakSystem;

/**
 * Represents blinds that can be opened or closed.
 */
public class Blinds extends Device implements Observer, Open {
    private Boolean isOpened = false;

    /**
     * Checks if the blinds are opened.
     *
     * @return true if the blinds are opened, false otherwise
     */
    public Boolean getOpened() {
        return isOpened;
    }

    /**
     * Sets the state of the blinds.
     *
     * @param opened true to open the blinds, false to close them
     */
    public void setOpened(Boolean opened) {
        isOpened = opened;
    }

    /**
     * Opens the blinds and increases the electricity consumption.
     */
    public void open() {
        getElectricityAPI().increaseCounter(getkWPerHour());
        isOpened = true;
    }

    /**
     * Closes the blinds and increases the electricity consumption.
     */
    public void close() {
        getElectricityAPI().increaseCounter(getkWPerHour());
        isOpened = false;
    }

    /**
     * Updates the state of the blinds based on the event received from the sensor.
     *
     * @param event  the event triggering the update
     * @param sensor the sensor associated with the event
     */
    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType().equals(EventType.STRONG_WIND)) {
            isOpened = false;
            System.out.println("Blinds are closed due to strong wind.");
        }
    }
}
