package entity.device;

public class Microwave extends Device{
    private final int maxUsageTimeMinutes;
    private final double power;
    public Microwave(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.maxUsageTimeMinutes = 30;
        this.power = 0;
    }
    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Microwave is now turned on.");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("Microwave is now turned off.");
    }
    public int getMaxUsageTimeMinutes() {
        return maxUsageTimeMinutes;
    }

    public double getPower() {
        return power;
    }
}
