package entity.sensor;

import entity.device.Device;
import entity.device.Fridge;
import entity.device.Observer;
import event.Event;
import report.EventReportStruct;
import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class FireSensor extends Device implements Observer {
    private List<Observer> observers = new ArrayList<>();

    public FireSensor(List<Observer> observers) {
        this.observers = observers;
    }

    public FireSensor() {
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
        FireSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("A fire broke out inside the house");
            observer.update(event, this);
            listeners.add(observer);
        }
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
        Event event = new Event("Fire detected", "Fire detected in the house");
        notifyAllObservers(event);
    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {
        System.out.println("Attached to water leak system");
    }

    @Override
    public void turnOn() {
        System.out.println("Fire sensor turned on");
    }

    @Override
    public void increaseTemp(int temp) {

    }

    @Override
    public void decreaseTemp(int temp) {

    }

}