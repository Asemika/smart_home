package entity.device;

import entity.device.patterns.BakingModeStrategy;
import entity.device.patterns.DefrostModeStrategy;
import entity.device.patterns.GrillModeStrategy;

import java.util.HashMap;
import java.util.Map;

public class Oven extends Device {
    private boolean isTurnedOn;
    private entity.device.OvenMode currentMode;
    private int currentTemperature;
    private Map<entity.device.OvenMode, OvenMode> modeStrategies;

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

    @Override
    public Object getElectricityAPI() {
        return null;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void addModeStrategy(entity.device.OvenMode mode, OvenMode strategy) {
        modeStrategies.put(mode, strategy);
    }

    public void removeModeStrategy(entity.device.OvenMode mode) {
        modeStrategies.remove(mode);
    }

    public void executeMode() {
        OvenMode strategy = modeStrategies.get(currentMode);
        if (strategy != null) {
            strategy.execute(this);
        } else {
            System.out.println("No mode strategy set.");
        }
    }

    private void initDefaultStrategies() {
        addModeStrategy(entity.device.OvenMode.BAKING, (OvenMode) new BakingModeStrategy());
        addModeStrategy(entity.device.OvenMode.DEFROST, (OvenMode) new DefrostModeStrategy());
        addModeStrategy(entity.device.OvenMode.GRILL, (OvenMode) new GrillModeStrategy());
    }

    public void setCurrentMode(entity.device.OvenMode mode) {
        this.currentMode = mode;
    }

    public entity.device.OvenMode getCurrentMode() {
        return currentMode;
    }

    public void setTemperature(int temperature) {
        this.currentTemperature = temperature;
    }

    public int getTemperature() {
        return currentTemperature;
    }
}
