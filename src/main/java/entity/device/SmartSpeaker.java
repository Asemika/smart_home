package entity.device;

public class SmartSpeaker extends Device{
    public SmartSpeaker(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
    }
}
