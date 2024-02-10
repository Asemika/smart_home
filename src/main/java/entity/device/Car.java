package entity.device;

/**
 * The `Car` class represents a simulated smart home device for controlling a car.
 */
public class Car {
    // Properties to store information about the car
    private String make;            // Make of the car
    private String model;           // Model of the car
    private int year;               // Year of the car manufacture
    private boolean isEngineRunning;

    /**
     * Constructs a new `Car` object with the specified make, model, and year.
     */
    public Car() {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isEngineRunning = false; // The engine is initially not running
    }

    /**
     * Starts the car's engine if it is not already running.
     */
    public void startEngine() {
        if (!isEngineRunning) {
            System.out.println("The engine is now running.");
            isEngineRunning = true;
        } else {
            System.out.println("The engine is already running.");
        }
    }

    /**
     * Stops the car's engine if it is running.
     */
    public void stopEngine() {
        if (isEngineRunning) {
            System.out.println("The engine has been stopped.");
            isEngineRunning = false;
        } else {
            System.out.println("The engine is already stopped.");
        }
    }

    /**
     * Simulates driving the car. Prints a message indicating whether the car is in motion.
     */
    public void driveCar() {
        if (isEngineRunning) {
            System.out.println("The car is in motion.");
        } else {
            System.out.println("Please start the engine before driving.");
        }
    }

}
