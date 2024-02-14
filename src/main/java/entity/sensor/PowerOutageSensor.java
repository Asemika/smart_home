/**
 * Represents a power outage sensor device.
 * This class extends the Device class and implements the Sensor interface to provide power outage detection functionality.
 */
package entity.sensor;

import States.TurnedOnState;

import entity.device.Device;
import entity.device.Observer;
import event.Event;
import event.EventType;
import report.EventReportStruct;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;


public class PowerOutageSensor extends Device implements Sensor {
    private List<Observer> observers = new ArrayList<>();
    private BackupGenerator backupGenerator;

    /**
     * Constructs a PowerOutageSensor object with a backup generator.
     * @param backupGenerator The backup generator associated with the sensor.
     */
    public PowerOutageSensor(BackupGenerator backupGenerator) {
        this.backupGenerator = backupGenerator;
        turnOn();
    }

    /**
     * Attaches an observer to the power outage sensor.
     * @param observer The observer to attach.
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Detaches an observer from the power outage sensor.
     * @param observer The observer to detach.
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all attached observers about a power outage event.
     * @param event The power outage event to notify about.
     */
    @Override
    public void notifyAllObservers(Event event) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        PowerOutageSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("The devices were unplugged due to a power outage");
            if (((Device) observer).getActivityState() instanceof TurnedOnState) {
                backupGenerator.addDevice((Device) observer);
                observer.update(event, this);
                listeners.add(observer);
            }
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }
}
