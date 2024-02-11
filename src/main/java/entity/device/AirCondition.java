package entity.device;

public class AirCondition extends Device {
    private  boolean isTurnedOn;
    private int temperature;
    private int externalTemperature;

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

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (isTurnedOn) {
            this.temperature = temperature;
            System.out.println(getName() + " temperature set to " + temperature + " degrees Celsius.");
        } else {
            System.out.println(getName() + " is turned off. Please turn it on first.");
        }
    }

    public int getExternalTemperature() {
        return externalTemperature;
    }

    public void setExternalTemperature(int externalTemperature) {
        this.externalTemperature = externalTemperature;
        System.out.println("External temperature set to " + externalTemperature + " degrees Celsius.");
    }

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
