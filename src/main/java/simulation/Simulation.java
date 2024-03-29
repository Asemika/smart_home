package simulation;

import entity.creature.Person;
import entity.creature.Pet;
import entity.device.Device;
import entity.device.Fridge;
import entity.sensor.*;
import event.Event;
import event.EventType;
import house.Floor;
import house.House;
import house.Room;
import report.ActivityAndUsageReport;
import report.ConsumptionReport;
import report.EventReport;
import report.HouseConfigurationReport;
import States.TurnedOnState;
import java.util.List;
import java.util.Random;

public class Simulation {
    private final static int DAYS = 60;

    public static void main(String[] args) {
        Configuration configuration = Configuration.getInstance();
        House house = configuration.initHouse();
        List<Person> people = configuration.getPeople();
        List<Pet> pets = configuration.getPets();
        List<Device> devicesByConsumption = configuration.getDevicesWithConsumption();
        List<Device> sensors = configuration.getSensors();
        String folderForReports = "1";
        startSimulation(house, people, pets, devicesByConsumption, sensors, folderForReports);

        Configuration2 configuration2 = Configuration2.getInstance();
        house = configuration2.initHouse();
        people = configuration2.getPeople();
        pets = configuration2.getPets();
        devicesByConsumption = configuration2.getDevicesWithConsumption();
        sensors = configuration2.getSensors();
        folderForReports = "2";
        startSimulation(house, people, pets, devicesByConsumption, sensors, folderForReports);
    }


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
            if (fridge != null && fridge.getActivityState() instanceof TurnedOnState) {
                fridge.getElectricityAPI().increaseCounter(fridge.getkWPerHour());
            }
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
     * returns random storey in the house
     *
     * @param floors
     * @return Storey
     */
    private static Floor getRandomFloor(List<Floor> floors) {
        Random random = new Random();
        int randFloorIndex = random.nextInt(floors.size());
        return floors.get(randFloorIndex);
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
            pet.changeRoom(getRandomFloor(house.getFloors()).getRooms());
        }

        List<Room> rooms = getRandomFloor(house.getFloors()).getRooms();
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
            pet.changeRoom(getRandomFloor(house.getFloors()).getRooms());
        }
    }

    /**
     * generates fire event and simulates it
     *
     * @param house
     */
    public static void simulateFireEvent(House house) {
        Event event = new Event(EventType.FIRE);
        for (Room room : getRandomFloor(house.getFloors()).getRooms()) {
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
        for (Room room : getRandomFloor(house.getFloors()).getRooms()) {
            for (Sensor s : room.getSensors()) {
                if (s instanceof WaterLeakSensor) s.notifyAllObservers(event);
            }
        }
    }

    /**
     * generates strong wind event and simulates it
     *
     * @param house
     */
    public static void simulateStrongWindEvent(House house) {
        Event event = new Event(EventType.STRONG_WIND);
        for (Room room : getRandomFloor(house.getFloors()).getRooms()) {
            for (Sensor s : room.getSensors()) {
                if (s instanceof StrongWindSensor) s.notifyAllObservers(event);
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
        for (Room room : getRandomFloor(house.getFloors()).getRooms()) {
            for (Sensor s : room.getSensors()) {
                if (s instanceof PowerOutageSensor) s.notifyAllObservers(event);
            }
        }

    }

    public static void simulateRandomEvent(House house) {
        Random random = new Random();
        int randNum = random.nextInt(4);
        switch (randNum) {
            case 0 -> simulateFireEvent(house);
            case 1 -> simulateStrongWindEvent(house);
            case 2 -> simulateWaterLeakEvent(house);
            case 3 -> simulatePowerOutageEvent(house);
        }
    }
}
