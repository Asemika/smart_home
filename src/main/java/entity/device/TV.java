package entity.device;

public class TV extends Device {

    private boolean isTurnedOn;
    private int volume;

    public TV() {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
        this.volume = 50; // Default volume
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

    public int getVolume() {
        return volume;
    }

    public void adjustVolume(int amount) {
        if (isTurnedOn) {
            volume = Math.min(100, Math.max(0, volume + amount)); // Adjust volume between 0 and 100
            System.out.println(getName() + " volume adjusted to " + volume);
        } else {
            System.out.println(getName() + " is turned off. Please turn it on first.");
        }
    }
    public void detectPeopleInRoom(boolean peopleInRoom) {
        if (peopleInRoom && !isTurnedOn) {
            turnOn();
        } else if (!peopleInRoom && isTurnedOn) {
            turnOff();
        }
    }
}
