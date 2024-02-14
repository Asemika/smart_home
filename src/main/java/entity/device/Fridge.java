/**
 * Represents a refrigerator device.
 * This class extends the Device class and provides functionality specific to a refrigerator, such as adding food, ordering more food, and managing observers.
 */
package entity.device;

import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.Sensor;
import entity.sensor.StrongWindSensor;
import event.Event;
import event.EventType;
import report.EventReportStruct;
import States.BrokenState;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class Fridge extends Device {

    private final List<Observer> observers = new ArrayList<>();
    private final List<Object> foodInFridge = new ArrayList<>();
    private final int foodLimitAmount = 10;

    /**
     * Constructs a Fridge object.
     * Initializes the Fridge with default values.
     */
    public Fridge() {
        super();
    }

    /**
     * Adds food to the fridge.
     * @return true if the food was successfully added, false otherwise
     */
    public boolean addFood() {
        if (isBroken()) {
            System.out.println("Device is broken. Can't use it now. Going to call someone to fix it");
            notifyAllObservers(new Event(EventType.BROKEN_DEVICE)); // call somebody to fix
            return false;
        }
        increaseUsageTime(100);
        if (getUsageTime() > getMAX_USAGE_CONSTANT()) {
            this.breakDevice();
            System.out.println("We're going to break this device");
            return false;
        }
        if (calculateFridgeFillPercentage() < 54) {
            orderFood();
        }
        if (foodInFridge.size() + 1 <= foodLimitAmount) {
            foodInFridge.add(new Object());
            return true;
        } else {
            System.out.println("Fridge is full");
            return false;
        }
    }

    /**
     * Initiates the process of ordering more food for the fridge.
     */
    private void orderFood() {
        System.out.println("Ordering more food...");
    }

    /**
     * Calculates the fill percentage of the fridge.
     * @return the fill percentage of the fridge
     */
    private double calculateFridgeFillPercentage() {
        return ((double) foodInFridge.size() / foodLimitAmount) * 100;
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
        Fridge sourceSensor = this;
        List<Observer> listeners = new ArrayList<>(observers);

        System.out.println("Fridge is empty OR broken");
        if (!listeners.isEmpty()) {
            for (Observer observer : listeners) {
                observer.update(event, this);
            }

            getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
        } else {
            System.out.println("No attached observers in fridge");
        }
    }

    /**
     * Opens the fridge.
     */
    public void open() {
    }

    /**
     * Closes the fridge.
     */
    public void close() {
    }
}
