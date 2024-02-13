package entity.sensor;

import entity.device.Device;
import entity.device.Observer;
import event.Event;
import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class FireSensor extends Device implements Sensor {
    private List<Observer> observers = new ArrayList<>();

    public FireSensor(List<Observer> observers) {
        this.observers = observers;
    }

    public FireSensor() {
        turnOn();
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
        Sensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("A fire broke out inside the house");
            observer.update(event, this);
            listeners.add(observer);
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void turnOn() {

    }

}