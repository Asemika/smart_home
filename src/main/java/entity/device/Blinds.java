package entity.device;

public class Blinds extends Device{
    public Blinds(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
    }
}
