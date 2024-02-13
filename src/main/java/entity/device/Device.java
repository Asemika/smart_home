package entity.device;

import API.ElectricityAPI;
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

    // Объект API электропотребления
    private ElectricityAPI electricityAPI;

    public Device(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        this.name = name;
        this.type = type;
        this.state = DeviceState.OFF;
        this.activeConsumption = activeConsumption;
        this.idleConsumption = idleConsumption;
        this.turnedOffConsumption = turnedOffConsumption;
    }

    public Device() {

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

    // Получение объекта API электропотребления
    public ElectricityAPI getElectricityAPI() {
        return electricityAPI;
    }

    // Установка объекта API электропотребления
    public void setElectricityAPI(ElectricityAPI electricityAPI) {
        this.electricityAPI = electricityAPI;
    }

    public double getkWPerHour() {
        return kWPerHour;
    }

    public void setkWPerHour(double kWPerHour) {
        this.kWPerHour = kWPerHour;
    }

    public void attach(Person person) {
    }

    public void notifyAllObservers(Event event) {
    }

//    public abstract Object getElectricityAPI();
}
