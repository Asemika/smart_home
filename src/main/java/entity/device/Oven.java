package entity.device;

import entity.device.interfaces.OvenModeStrategy;
import entity.device.patterns.BakingModeStrategy;
import entity.device.patterns.DefrostModeStrategy;
import entity.device.patterns.GrillModeStrategy;

import java.util.HashMap;
import java.util.Map;

public class Oven extends Device {
    private boolean isTurnedOn;
    private OvenMode currentMode;
    private int currentTemperature;
    private Map<OvenMode, OvenModeStrategy> modeStrategies;

    public Oven(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
        this.modeStrategies = new HashMap<>();
        initDefaultStrategies();
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println(getName() + " is turned on.");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println(getName() + " is turned off.");
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void addModeStrategy(OvenMode mode, OvenModeStrategy strategy) {
        modeStrategies.put(mode, strategy);
    }

    public void removeModeStrategy(OvenMode mode) {
        modeStrategies.remove(mode);
    }

    public void executeMode() {
        OvenModeStrategy strategy = modeStrategies.get(currentMode);
        if (strategy != null) {
            strategy.execute(this);
        } else {
            System.out.println("No mode strategy set.");
        }
    }

    private void initDefaultStrategies() {
        addModeStrategy(OvenMode.BAKING, new BakingModeStrategy());
        addModeStrategy(OvenMode.DEFROST, new DefrostModeStrategy());
        addModeStrategy(OvenMode.GRILL, new GrillModeStrategy());
    }

    public void setCurrentMode(OvenMode mode) {
        this.currentMode = mode;
    }

    public OvenMode getCurrentMode() {
        return currentMode;
    }

    public void setTemperature(int temperature) {
        this.currentTemperature = temperature;
    }

    public int getTemperature() {
        return currentTemperature;
    }
}
