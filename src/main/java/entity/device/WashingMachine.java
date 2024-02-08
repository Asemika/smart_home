package entity.device;

public class WashingMachine extends Device{
    public WashingMachine(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
    }
}
