package entity.sensor;

import entity.device.Device;
import entity.device.Fridge;
import entity.device.Observer;
import event.Event;
import report.EventReportStruct;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class WaterLeakSensor extends Device implements Observer {
    List<Observer> observers = new ArrayList<>();

    public WaterLeakSensor(List<Observer> observers) {
        this.observers = observers;
    }

    public WaterLeakSensor() {
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
        WaterLeakSensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("Water is leaking in our house");
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
    public void update(Event event, Fridge fridge) {

    }
}