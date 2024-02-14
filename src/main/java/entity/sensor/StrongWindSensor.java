/**
 * Represents a strong wind sensor device.
 * This class extends the Device class and implements the Sensor interface to provide strong wind detection functionality.
 */
package entity.sensor;

import entity.device.Device;
import entity.device.Observer;
import event.Event;
import report.EventReportStruct;

import java.util.ArrayList;
import java.util.List;

public class StrongWindSensor extends Device implements Sensor {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructs a StrongWindSensor object with a list of observers.
     * @param observers The list of observers to attach to the sensor.
     */
    public StrongWindSensor(List<Observer> observers) {
        this.observers = observers;
    }

    /**
     * Constructs a StrongWindSensor object.
     */
    public StrongWindSensor() {
        turnOn();
    }

    /**
     * Attaches an observer to the strong wind sensor.
     * @param observer The observer to attach.
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Detaches an observer from the strong wind sensor.
     * @param observer The observer to detach.
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all attached observers about a strong wind event.
     * @param event The strong wind event to notify about.
     */
    @Override
    public void notifyAllObservers(Event event) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        StrongWindSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("Strong wind is approaching our house");
            observer.update(event, this);
            listeners.add(observer);
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }
}
