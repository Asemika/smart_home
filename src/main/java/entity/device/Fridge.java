package entity.device;

import API.FridgeState;
import entity.sensor.Sensor;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class Fridge extends Device implements Sensor {
    private boolean isTurnedOn;
    private int foodPercentage;
    private final List<Observer> observers = new ArrayList<>();

    public Fridge() {
        super("Fridge", DeviceType.FRIDGE, 10.0, 5.0, 2.0);
        this.isTurnedOn = false;
        this.foodPercentage = 50;
    }

    @Override
    public void notifySystem() {



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

    @Override
    public void setState(Fridge fridge) {

    }

    public void orderFoodIfNeeded(int thresholdPercentage) {
        if (foodPercentage < thresholdPercentage) {
            System.out.println("Food percentage is low. Ordering more food...");
        } else {
            System.out.println("Food percentage is sufficient. No need to order.");
        }
    }
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Event event) {
        Sensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();

        System.out.println("Fridge is empty OR broken");
        if (observers.size() > 0) {
            observers.get(0).update(event, this);
            listeners.add(observers.get(0));
            getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
        } else System.out.println("No attached observers in fridge");

    }
}

//package entity.device;
//
//        import API.ElectricityAPI;
//        import entity.device.interfaces.FridgeState;
//
//public class Fridge extends Device{
//    private boolean isTurnedOn;
//    private int foodPercentage;
//
//    public Fridge(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
//        super("Fridge", DeviceType.FRIDGE, 10.0, 5.0, 2.0);
//        this.isTurnedOn = false;
//        this.foodPercentage = 50;
//    }
//    @Override
//    public void turnOn() {
//        if (!isTurnedOn) {
//            isTurnedOn = true;
//            System.out.println(getName() + " is turned on.");
//        }
//    }
//
//    @Override
//    public void turnOff() {
//        if (isTurnedOn)
//            System.out.println(getName() + " is turned off.");
//    }
//
//    public boolean isTurnedOn() {
//        return isTurnedOn;
//    }
//
//    public int getFoodPercentage() {
//        return foodPercentage;
//    }
//
//    public void setFoodPercentage(int foodPercentage) {
//        this.foodPercentage = Math.min(100, Math.max(0, foodPercentage)); // Ensure food percentage is between 0 and 100
//    }
//    public void open() {
//        System.out.println("Fridge is now open.");
//    }
//
//    public void close() {
//        System.out.println("Fridge is now closed.");
//    }
//
//    public void orderFoodIfNeeded(int thresholdPercentage) {
//        if (foodPercentage < thresholdPercentage) {
//            System.out.println("Food percentage is low. Ordering more food...");
//        } else {
//            System.out.println("Food percentage is sufficient. No need to order.");
//        }
//    }
//    public void setState(DeviceState state) {
//        if (state == DeviceState.ON && !isTurnedOn) {
//            turnOn();
//        } else if (state == DeviceState.OFF && isTurnedOn) {
//            turnOff();
//        } else {
//            System.out.println("Fridge is already in the desired state.");
//        }
//    }
//
//    public Object getActivityState() {
//    }
//
//    public ElectricityAPI getElectricityAPI() {
//        return electricityAPI;
//    }
//
//    public void setElectricityAPI(ElectricityAPI electricityAPI) {
//        this.electricityAPI = electricityAPI;
//    }
//}
