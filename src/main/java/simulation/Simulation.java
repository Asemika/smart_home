package simulation;

import entity.creature.Person;
import entity.creature.Pet;
import house.*;
import entity.device.*;
import entity.sensor.*;
import report.*;
import event.*;

import java.util.List;
import java.util.Random;

public class Simulation {
    private final static int DAYS = 60;


    /**
     * executes simulation itself
     *
     * @param house
     * @param people
     * @param pets
     * @param devicesByConsumption
     * @param sensors
     * @param folderForReports
     */
    public static void startSimulation(House house, List<Person> people, List<Pet> pets,
                                       List<Device> devicesByConsumption, List<Device> sensors, String folderForReports) {
        Fridge fridge = null;
        for (Device d : devicesByConsumption) {
            if (d instanceof Fridge) fridge = (Fridge) d;
        }

        for (int i = 0; i < DAYS; i++) {
            simulateDay(house, people, pets);
            if (i == 3 || i == 10 || i == 20 || i == 45) {
                simulateRandomEvent(house);
            }
            if (fridge != null && fridge.getActivityState() instanceof TurnedOnState)
                fridge.getElectricityAPI().increaseCounter(fridge.getkWPerHour());
        }

        ConsumptionReport consumptionReport = new ConsumptionReport(devicesByConsumption, 10, 1, folderForReports);
        consumptionReport.generateReport();
        EventReport eventReport = new EventReport(sensors, folderForReports);
        eventReport.generateReport();
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport(people, pets, folderForReports);
        activityAndUsageReport.generateReport();
        HouseConfigurationReport houseConfReport = new HouseConfigurationReport(house, people, pets, folderForReports);
        houseConfReport.generateReport();

    }

    /**
     * simulates family activity during day
     *
     * @param house
     * @param people
     * @param pets
     */
    private static void simulateDay(House house, List<Person> people, List<Pet> pets) {
        for (Person person : people) {
            person.rideBicycle();
            person.useSkis();
        }
        for (Person person : people) {
            person.doRandomActivity();
        }

        for (Pet pet : pets) {
            pet.changeRoom(getRandomStorey(house.getStoreys()).getRooms());
        }

        List<Room> rooms = getRandomStorey(house.getStoreys()).getRooms();
        for (Person person : people) {
            person.changeRoom(rooms);
        }

        for (Person person : people) {
            person.rideBicycle();
            person.useSkis();
        }

        for (Person person : people) {
            person.doRandomActivity();
        }
        for (Pet pet : pets) {
            pet.changeRoom(getRandomStorey(house.getStoreys()).getRooms());
        }
    }

    /**
     * generates fire event and simulates it
     *
     * @param house
     */
    public static void simulateFireEvent(House house) {
        Event event = new Event(EventType.FIRE);
        for (Room room : getRandomStorey(house.getStoreys()).getRooms()) {
            for (Sensor s : room.getSensors()) {
                if (s instanceof FireSensor) s.notifyAllObservers(event);
            }
        }
    }

    /**
     * generates water leak event and simulates it
     *
     * @param house
     */
    public static void simulateWaterLeakEvent(House house) {
        Event event = new Event(EventType.WATER_LEAK);
        for (Room room : getRandomStorey(house.getStoreys()).getRooms()) {
            for (Sensor s : room.getSensors()) {
                if (s instanceof WaterLeakSensor) s.notifyAllObservers(event);
            }
        }
    }

    /**
     * generates power outage event and simulates it
     *
     * @param house
     */
    public static void simulatePowerOutageEvent(House house) {
        Event event = new Event(EventType.POWER_OUTAGE);
        for (Room room : getRandomStorey(house.getStoreys()).getRooms()) {
            for (Sensor s : room.getSensors()) {
                if (s instanceof PowerOutageSensor) s.notifyAllObservers(event);
            }
        }

    }

    public static void simulateRandomEvent(House house) {
        Random random = new Random();
        int randNum = random.nextInt(3);
        switch (randNum) {
            case 0 -> simulateFireEvent(house);
            case 1 -> simulateWaterLeakEvent(house);
            case 2 -> simulatePowerOutageEvent(house);
        }
    }
}