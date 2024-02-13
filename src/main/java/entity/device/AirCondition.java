package entity.device;

/**
 * Represents an air conditioner device.
 */
public class AirCondition extends Device {
    private boolean isTurnedOn;
    private int temperature;
    private int externalTemperature;
    /**
     * Constructs an air conditioner with the given parameters.
     *
     * @param name               the name of the air conditioner
     * @param type               the type of the air conditioner
     * @param powerConsumption   the power consumption of the air conditioner when turned on (in watts)
     * @param idleConsumption    the power consumption of the air conditioner in idle state (in watts)
     * @param turnedOffConsumption  the power consumption of the air conditioner when turned off (in watts)
     */
    public AirCondition(String name, DeviceType type, double powerConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, powerConsumption, idleConsumption, turnedOffConsumption);
        this.temperature = 20; // Default temperature setting
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
//
//    @Override
//    public Object getElectricityAPI() {
//        return null;
//    }

    /**
     * Checks if the air conditioner is turned on.
     *
     * @return true if the air conditioner is turned on, false otherwise
     */
    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    /**
     * Gets the current temperature setting of the air conditioner.
     *
     * @return the current temperature setting of the air conditioner (in Celsius)
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature setting of the air conditioner.
     *
     * @param temperature the desired temperature setting (in Celsius)
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature setting of " + getName() + " changed to " + temperature + "°C");
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
