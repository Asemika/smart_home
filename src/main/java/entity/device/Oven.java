package entity.device;

import API.ElectricityAPI;
import API.OvenAPI;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.StrongWindSensor;
import event.Event;
import systems.WaterLeakSystem;
//import entity.device.patterns.BakingModeStrategy;
//import entity.device.patterns.DefrostModeStrategy;
//import entity.device.patterns.GrillModeStrategy;

import java.util.HashMap;
import java.util.Map;

public class Oven extends Device {
    private boolean isTurnedOn;
    private OvenAPI currentMode;
    private int currentTemperature;
    private Map<OvenAPI, OvenAPI> modeStrategies;
    private boolean name;

    public Oven(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
        this.modeStrategies = new HashMap<>();
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

    @Override
    public void update(Event event, Fridge fridge) {

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
    public void turnOn() {
        isTurnedOn = true;
        System.out.println(getName() + " is turned on.");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println(getName() + " is turned off.");
    }
//
//    @Override
//    public void notifySystem() {
//
//    }
//
//    @Override
//    public void attach(WaterLeakSystem waterLeakSystem) {
//
//    }
//
//    @Override
//    public void increaseTemp(int temp) {
//
//    }
//
//    @Override
//    public void decreaseTemp(int temp) {
//
//    }
//
////    @Override
////    public ElectricityAPI getElectricityAPI() {
////        return null;
////    }
//
//    public boolean isTurnedOn() {
//        return isTurnedOn;
//    }
//
//    public void addModeStrategy(OvenAPI mode, OvenAPI strategy) {
//        modeStrategies.put(mode, strategy);
//    }
//
//    public void removeModeStrategy(OvenAPI mode) {
//        modeStrategies.remove(mode);
//    }
//
//    public void executeMode() {
//        OvenAPI strategy = modeStrategies.get(currentMode);
//        if (strategy != null) {
//            strategy.execute(this);
//        } else {
//            System.out.println("No mode strategy set.");
//        }
//    }
//
//    public void setCurrentMode(OvenAPI mode) {
//        this.currentMode = mode;
//    }
//
//    public OvenAPI getCurrentMode() {
//        return currentMode;
//    }
//
//    public void setTemperature(int temperature) {
//        this.currentTemperature = temperature;
//    }
//
//    public int getTemperature() {
//        return currentTemperature;
//    }
//
//    public boolean getName() {
//        return name;
//    }
//
//    @Override
//    public void update(Event event, Fridge fridge) {
//
//    }
}
