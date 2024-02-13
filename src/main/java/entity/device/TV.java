package entity.device;

/**
 * Represents a TV device.
 */
public class TV extends Device {
    private boolean isTurnedOn;
    private int volume;

    /**
     * Constructs a TV with specified parameters.
     *
     * @param name               the name of the TV
     * @param activeConsumption  the active consumption of the TV
     * @param idleConsumption    the idle consumption of the TV
     * @param turnedOffConsumption the consumption when the TV is turned off
     */
    public TV(String name, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, DeviceType.TV, activeConsumption, idleConsumption, turnedOffConsumption);
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

    @Override
    public Object getElectricityAPI() {
        return null;
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
