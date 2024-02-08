package entity.device;

public class Fridge extends Device{
    private boolean isTurnedOn;
    private int foodPercentage;

    public Fridge(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
        super("Fridge", DeviceType.FRIDGE, 10.0, 5.0, 2.0);
        this.isTurnedOn = false;
        this.foodPercentage = 50;
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
        if (isTurnedOn)
            System.out.println(getName() + " is turned off.");
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public int getFoodPercentage() {
        return foodPercentage;
    }

    public void setFoodPercentage(int foodPercentage) {
        this.foodPercentage = Math.min(100, Math.max(0, foodPercentage)); // Ensure food percentage is between 0 and 100
    }
    public void open() {
        System.out.println("Fridge is now open.");
    }

    public void close() {
        System.out.println("Fridge is now closed.");
    }

    public void orderFoodIfNeeded(int thresholdPercentage) {
        if (foodPercentage < thresholdPercentage) {
            System.out.println("Food percentage is low. Ordering more food...");
        } else {
            System.out.println("Food percentage is sufficient. No need to order.");
        }
    }
}
