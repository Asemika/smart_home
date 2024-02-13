package entity.device;

import API.ElectricityAPI;
import API.OvenAPI;
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
//    nuzhno li pomenat OvenMode na OvenAPI?

    public Oven() {
//        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
//        this.isTurnedOn = false;
//        this.modeStrategies = new HashMap<>();
//        initDefaultStrategies();
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println(getName() + " is turned on.");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println(getName() + " is turned off.");
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
    public ElectricityAPI getElectricityAPI() {
        return null;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void addModeStrategy(OvenAPI mode, OvenAPI strategy) {
        modeStrategies.put(mode, strategy);
    }

    public void removeModeStrategy(OvenAPI mode) {
        modeStrategies.remove(mode);
    }

    public void executeMode() {
        OvenAPI strategy = modeStrategies.get(currentMode);
        if (strategy != null) {
            strategy.execute(this);
        } else {
            System.out.println("No mode strategy set.");
        }
    }

//    private void initDefaultStrategies() {
//        addModeStrategy(OvenMode.BAKING, (OvenMode) new BakingModeStrategy());
//        addModeStrategy(OvenMode.DEFROST, (OvenMode) new DefrostModeStrategy());
//        addModeStrategy(OvenMode.GRILL, (OvenMode) new GrillModeStrategy());
//    }

    public void setCurrentMode(OvenAPI mode) {
        this.currentMode = mode;
    }

    public OvenAPI getCurrentMode() {
        return currentMode;
    }

    public void setTemperature(int temperature) {
        this.currentTemperature = temperature;
    }

    public int getTemperature() {
        return currentTemperature;
    }

    public boolean getName() {
        return name;
    }

    @Override
    public void update(Event event, Fridge fridge) {

    }
}
