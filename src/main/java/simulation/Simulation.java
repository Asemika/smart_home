package simulation;

import entity.creature.Person;
import entity.creature.Pet;
import house.*;
import entity.device.*;
import entity.sensor.*;
import report.*;
import event.*;

import java.util.List;
import java.util.Objects;
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
            pet.changeRoom((List<Room>) getRandomStorey(house.getStoreys()).getRooms());
        }

        List<Room> rooms = getRandomStorey(house.getStoreys()).getRooms();
        for (Person person : people) {
            person.changeRoom(rooms);
        }

        // Close blinds when needed
        for (Room room : rooms) {
            for (Window window : room.getWindows()) {
                window.closeBlindsWhenNeeded();
            }
        }

        for (Person person : people) {
            person.rideBicycle();
            person.useSkis();
        }

        for (Person person : people) {
            person.doRandomActivity();
        }

        for (Pet pet : pets) {
            pet.changeRoom((List<Room>) getRandomStorey(house.getStoreys()).getRooms());
        }
    }


    /**
     * generates fire event and simulates it
     *
     * @param house
     */
    private static void simulateFireEvent(House house) {
        Event event = new Event(EventType.FIRE);
        Storey randomStorey = getRandomStorey(house);
        if (randomStorey != null) {
            for (Room room : randomStorey.getRooms()) {
                for (Sensor sensor : room.getSensors()) {
                    if (sensor instanceof FireSensor) {
                        sensor.notifyAllObservers(event);
                        break;
                    }
                }
            }
        }
    }


    /**
     * generates water leak event and simulates it
     *
     * @param house
     */
    private static void simulateWaterLeakEvent(House house) {
        Event event = new Event(EventType.WATER_LEAK);
        Storey randomStorey = getRandomStorey(house);
        if (randomStorey != null) {
            for (Room room : randomStorey.getRooms()) {
                for (Sensor sensor : room.getSensors()) {
                    if (sensor instanceof WaterLeakSensor) {
                        sensor.notifyAllObservers(event);
                        break;
                    }
                }
            }
        }
    }


    /**
     * generates power outage event and simulates it
     *
     * @param house
     */
    private static void simulatePowerOutageEvent(House house) {
        Event event = new Event(EventType.POWER_OUTAGE);
        for (Storey storey : house.getStoreys()) {
            for (Room room : storey.getRooms())
                for (Device device : room.getDevices()) {
                    device.notifyAllObservers(event);
                }
        }
    }


    private static Storey getRandomStorey(House house) {
        House storeys = house.getStoreys();
        if (!storeys.isEmpty()) {
            Random random = new Random();
            return storeys.get(random.nextInt(storeys.size()));
        }
        return null;
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