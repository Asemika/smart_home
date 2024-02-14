/**
 * Represents a water leak sensor device.
 * This class extends the Device class and implements the Sensor interface to provide water leak detection functionality.
 */
package entity.sensor;

import entity.device.Device;
import entity.device.Observer;
import event.Event;
import report.EventReportStruct;

import java.util.ArrayList;
import java.util.List;

public class WaterLeakSensor extends Device implements Sensor {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructs a WaterLeakSensor object with a list of observers.
     * @param observers The list of observers to attach to the sensor.
     */
    public WaterLeakSensor(List<Observer> observers) {
        this.observers = observers;
    }

    /**
     * Constructs a WaterLeakSensor object.
     */
    public WaterLeakSensor() {
        turnOn();
    }

    /**
     * Attaches an observer to the water leak sensor.
     * @param observer The observer to attach.
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Detaches an observer from the water leak sensor.
     * @param observer The observer to detach.
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all attached observers about a water leak event.
     * @param event The water leak event to notify about.
     */
    @Override
    public void notifyAllObservers(Event event) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        WaterLeakSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("Water is leaking in our house");
            observer.update(event, this);
            listeners.add(observer);
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }
}
