package entity.device;

import entity.creature.Person;
import event.Event;

public abstract class Device {
    private String name;
    private DeviceType type;
    private DeviceState state;
    private double activeConsumption;
    private double idleConsumption;
    private double turnedOffConsumption;
    private double kWPerHour;

    public Device(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        this.name = name;
        this.type = type;
        this.state = DeviceState.OFF;
        this.activeConsumption = activeConsumption;
        this.idleConsumption = idleConsumption;
        this.turnedOffConsumption = turnedOffConsumption;
    }

    public void turnOn() {
        this.state = DeviceState.ON;
        System.out.println(name + " is turned on.");
    }

    public void turnOff() {
        this.state = DeviceState.OFF;
        System.out.println(name + " is turned off.");
    }

    public DeviceType getType() {
        return type;
    }

    public DeviceState getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public double getActiveConsumption() {
        return activeConsumption;
    }

    public double getIdleConsumption() {
        return idleConsumption;
    }

    public double getTurnedOffConsumption() {
        return turnedOffConsumption;
    }

    public void attach(Person person) {
    }

    public double getkWPerHour() {
        return kWPerHour;
    }

    public void setkWPerHour(double kWPerHour) {
        this.kWPerHour = kWPerHour;
    }

    public void notifyAllObservers(Event event) {
    }
}
