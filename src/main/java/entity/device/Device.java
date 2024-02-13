package entity.device;

import API.ElectricityAPI;
import API.EventAPI;
import States.*;
import entity.creature.Person;
import entity.sensor.Sensor;
import event.Event;
import event.EventType;
import report.EventReportStruct;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class Device extends Sensor implements Observer  {
    private final int MAX_USAGE_CONSTANT = 1500;
    private ActivityState activityState = new TurnedOffState();
    private BreakdownsState breakdownsState = new FixedState();
    private int wearOut;
    private final Documentation documentation = new Documentation();
    private final List<Observer> observers = new ArrayList<>();
    private final ElectricityAPI electricityAPI = new ElectricityAPI();
    private final EventAPI eventAPI = new EventAPI();
    private int kWPerHour;

    public Device(int kWPerHour) {
        this.kWPerHour = kWPerHour;
    }

    public Device() {
        this.kWPerHour = 1;
    }

    public ActivityState getActivityState() {
        return activityState;
    }

    public void setActivityState(ActivityState activityState) {
        this.activityState = activityState;
    }

    public EventAPI getEventAPI() {
        return eventAPI;
    }

    public int getkWPerHour() {
        return kWPerHour;
    }

    public void setkWPerHour(int kWPerHour) {
        this.kWPerHour = kWPerHour;
    }

    public ElectricityAPI getElectricityAPI() {
        return electricityAPI;
    }

    public int getUsageTime() {
        return wearOut;
    }

    public void setUsageTime(int usageTime) {
        this.wearOut = usageTime;
    }

    public BreakdownsState getBreakdownsState() {
        return breakdownsState;
    }
    public boolean isBroken() {
        return breakdownsState instanceof BrokenState;
    }
    public void increaseUsageTime(int time) {
        wearOut += time;
    }
    public void setBreakdownsState(BreakdownsState breakdownsState) {
        this.breakdownsState = breakdownsState;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    /**
     * turns on device. fails if device is broken and requires person to fix it. every usage increments wear out value.
     */
    public void turnOn() {
        if (this.breakdownsState instanceof BrokenState) {
            System.out.println("Device is broken. Cant use it now. Gonna call smone to fix it");
            notifyAllObservers(new Event(EventType.BROKEN_DEVICE)); // call somebody to fix
            return;
        }
        wearOut += 100;
        if (wearOut > MAX_USAGE_CONSTANT) {
            this.breakDevice();
            System.out.println("we gonna break this device");
            setkWPerHour(getkWPerHour() + 1);
            return;
        }
        activityState.turnOn(this);
    }

    public void turnOff() {
        activityState.turnOff(this);
    }

    public void breakDevice() {
        breakdownsState.breakDevice(this);
    }

    public void fixDevice() {
        breakdownsState.fixDevice(this);
        wearOut = 0;
    }

    @Override
    public void update(Event event, Sensor sensor) {
        this.turnOff();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * notifies some person about broken device.
     *
     * @param event
     */
    @Override
    public void notifyAllObservers(Event event) {
        Sensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();

        if (observers.size() > 0) {
            observers.get(0).update(event, this);
            listeners.add(observers.get(0));
            getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
        } else System.out.println("No attached observers");

    }

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    public int getMAX_USAGE_CONSTANT() {
        return MAX_USAGE_CONSTANT;
    }
}

//package entity.device;
//
//import API.ElectricityAPI;
//import entity.creature.Person;
//import event.Event;
//
//public abstract class Device {
//    private String name;
//    private DeviceType type;
//    private DeviceState state;
//    private double activeConsumption;
//    private double idleConsumption;
//    private double turnedOffConsumption;
//    private double kWPerHour;
//
//    // Объект API электропотребления
//    private ElectricityAPI electricityAPI;
//
//    public Device(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
//        this.name = name;
//        this.type = type;
//        this.state = DeviceState.OFF;
//        this.activeConsumption = activeConsumption;
//        this.idleConsumption = idleConsumption;
//        this.turnedOffConsumption = turnedOffConsumption;
//    }
//
//    public Device() {
//
//    }
//
//    public void turnOn() {
//        this.state = DeviceState.ON;
//        System.out.println(name + " is turned on.");
//    }
//
//    public void turnOff() {
//        this.state = DeviceState.OFF;
//        System.out.println(name + " is turned off.");
//    }
//
//    public DeviceType getType() {
//        return type;
//    }
//
//    public DeviceState getState() {
//        return state;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getActiveConsumption() {
//        return activeConsumption;
//    }
//
//    public double getIdleConsumption() {
//        return idleConsumption;
//    }
//
//    public double getTurnedOffConsumption() {
//        return turnedOffConsumption;
//    }
//
//    // Получение объекта API электропотребления
//    public ElectricityAPI getElectricityAPI() {
//        return electricityAPI;
//    }
//
//    // Установка объекта API электропотребления
//    public void setElectricityAPI(ElectricityAPI electricityAPI) {
//        this.electricityAPI = electricityAPI;
//    }
//
//    public double getkWPerHour() {
//        return kWPerHour;
//    }
//
//    public void setkWPerHour(double kWPerHour) {
//        this.kWPerHour = kWPerHour;
//    }
//
//    public void attach(Person person) {
//    }
//
//    public void notifyAllObservers(Event event) {
//    }
//
////    public abstract Object getElectricityAPI();
//}
