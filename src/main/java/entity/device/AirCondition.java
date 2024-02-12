package entity.device;

/**
 * Represents an air conditioner device.
 */
public abstract class AirCondition extends Device {
    private boolean isTurnedOn;
    private int temperature;
    private int externalTemperature;

    /**
     * Constructs an air conditioner with specified parameters.
     *
     * @param name               the name of the air conditioner
     * @param type               the type of the device
     * @param activeConsumption  the active consumption of the air conditioner
     * @param idleConsumption    the idle consumption of the air conditioner
     * @param turnedOffConsumption the consumption when the air conditioner is turned off
     */
    public AirCondition(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
        this.temperature = 20; // Default temperature
        this.externalTemperature = 25; // Default external temperature
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

    /**
     * Checks if the air conditioner is turned on.
     *
     * @return true if the air conditioner is turned on, false otherwise
     */
    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    /**
     * Gets the temperature setting of the air conditioner.
     *
     * @return the temperature setting
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature of the air conditioner.
     *
     * @param temperature the temperature to set
     */
    public void setTemperature(int temperature) {
        if (isTurnedOn) {
            this.temperature = temperature;
            System.out.println(getName() + " temperature set to " + temperature + " degrees Celsius.");
        } else {
            System.out.println(getName() + " is turned off. Please turn it on first.");
        }
    }

    /**
     * Gets the external temperature.
     *
     * @return the external temperature
     */
    public int getExternalTemperature() {
        return externalTemperature;
    }

    /**
     * Sets the external temperature.
     *
     * @param externalTemperature the external temperature to set
     */
    public void setExternalTemperature(int externalTemperature) {
        this.externalTemperature = externalTemperature;
        System.out.println("External temperature set to " + externalTemperature + " degrees Celsius.");
    }

    /**
     * Controls the air conditioner based on the external temperature.
     */
    public void controlBasedOnExternalTemperature() {
        if (isTurnedOn) {
            if (externalTemperature > 25) {
                System.out.println("It's hot outside. Turning on the air conditioner to cool.");
            } else {
                System.out.println("It's not too hot outside. No need to use the air conditioner.");
            }
        } else {
            System.out.println(getName() + " is turned off. Please turn it on first.");
        }
    }
}
