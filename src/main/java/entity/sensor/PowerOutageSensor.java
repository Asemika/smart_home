package entity.sensor;

import States.TurnedOnState;
import entity.device.AirCondition;
import entity.device.Device;
import entity.device.Fridge;
import entity.device.Observer;
import event.Event;
import event.EventType;
import report.EventReportStruct;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class PowerOutageSensor extends Device implements Observer {
    List<Observer> observers = new ArrayList<>(); // devices
    BackupGenerator backupGenerator;

    public PowerOutageSensor(BackupGenerator backupGenerator) {
        this.backupGenerator = backupGenerator;
        turnOn();
    }

    @Override
    public void update(Event event, Fridge fridge) {

    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Event event) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        PowerOutageSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("The devices were unplugged due power outage");
            if (((Device) observer).getActivityState() instanceof TurnedOnState) {
                backupGenerator.addDevice((Device) observer);
                observer.update(event, this);
                listeners.add(observer);
            }
        }
        backupGenerator.update(new Event(EventType.POWER_OUTAGE), this);
        listeners.add(backupGenerator);

        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }

    @Override
    public void update(Event event, FireSensor fireSensor) {

    }

    @Override
    public void update(Event event, PowerOutageSensor powerOutageSensor) {

    }

    @Override
    public void update(Event event, StrongWindSensor strongWindSensor) {

    }

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void increaseTemp(int temp) {

    }

    @Override
    public void decreaseTemp(int temp) {

    }

    @Override
    public void update(Event event, AirCondition airCondition) {

    }
}