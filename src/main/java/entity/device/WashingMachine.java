package entity.device;

import API.ElectricityAPI;

public class WashingMachine extends Device {

    private boolean isTurnedOn;
    private boolean isWashing;
    private static final int WATER_CONSUMPTION_PER_WASH = 100;

    private ElectricityAPI electricityAPI;

    public WashingMachine() {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.isTurnedOn = false;
        this.isWashing = false;
        this.electricityAPI = electricityAPI;
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
            if (isWashing) {
                stopWashing();
            }
        }
    }

    public void startWashing() {
        if (isTurnedOn && !isWashing) {
            isWashing = true;
            System.out.println(getName() + " has started washing.");

            electricityAPI.increaseCounter(getActiveConsumption());
            consumeWater();
        } else {
            System.out.println("Cannot start washing. Washing machine is either turned off or already washing.");
        }
    }

    private void consumeWater() {
        System.out.println(getName() + " is consuming water during washing.");
    }
    public void stopWashing() {
        if (isWashing) {
            isWashing = false;
            System.out.println(getName() + " has finished washing.");
        } else {
            System.out.println("Washing machine is not currently washing.");
        }
    }
}