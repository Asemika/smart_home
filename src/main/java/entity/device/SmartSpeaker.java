package entity.device;
public class SmartSpeaker extends Device {

    private boolean isTurnedOn;

    public SmartSpeaker(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
    }

    public SmartSpeaker() {
        super();
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        if (!isTurnedOn) {
            isTurnedOn = true;
            System.out.println(getName() + " is turned on.");
        }
    }

    public void turnOff() {
        if (isTurnedOn) {
            isTurnedOn = false;
            System.out.println(getName() + " is turned off.");
        }
    }
}