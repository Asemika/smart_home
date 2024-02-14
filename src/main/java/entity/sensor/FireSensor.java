/**
 * Represents a fire sensor device.
 * This class extends the Device class and implements the Sensor interface to provide fire detection functionality.
 */
package entity.sensor;

import entity.device.Device;
import entity.device.Observer;
import event.Event;
import report.EventReportStruct;

import java.util.ArrayList;
import java.util.List;

public class FireSensor extends Device implements Sensor {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructs a FireSensor object with a list of observers.
     * @param observers The list of observers to attach to the sensor.
     */
    public FireSensor(List<Observer> observers) {
        this.observers = observers;
    }

    /**
     * Constructs a FireSensor object and turns it on.
     */
    public FireSensor() {
        turnOn();
    }

    /**
     * Attaches an observer to the fire sensor.
     * @param observer The observer to attach.
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Detaches an observer from the fire sensor.
     * @param observer The observer to detach.
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all attached observers about a fire event.
     * @param event The fire event to notify about.
     */
    @Override
    public void notifyAllObservers(Event event) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        FireSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("A fire broke out inside the house");
            observer.update(event, this);
            listeners.add(observer);
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }

    /**
     * Turns on the fire sensor.
     */
    @Override
    public void turnOn() {
        System.out.println("Fire sensor turned on");
    }
}
