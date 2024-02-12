package entity.device;

public abstract class SmartSpeaker extends Device {
    private boolean isTurnedOn;

    public SmartSpeaker() {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
    }

    @Override
    public void turnOn() {
        if (!isTurnedOn) {
            isTurnedOn = true;
            System.out.println(getName() + " is turned on.");
        }
    }

    @Override
    public void turnOff() {
        if (isTurnedOn) {
            isTurnedOn = false;
            System.out.println(getName() + " is turned off.");
        }
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }
}
