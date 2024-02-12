package simulation;

import entity.creature.Person;
import entity.creature.Pet;
import entity.device.Device;
import entity.device.Fridge;
import entity.sensor.Sensor;
import event.Event;
import event.EventType;
import house.House;
import house.Room;
import house.Storey;
import report.ActivityAndUsageReport;
import report.EventReport;
import report.ConsumptionReport;

import java.util.List;
import java.util.Random;

public class Simulation {
    private final static int DAYS = 60;

    public static void startSimulation(House house, List<Person> people, List<Pet> pets,
                                       List<Device> devicesByConsumption, List<Device> sensors, String folderForReports) {
        Fridge fridge = null;
        for (Device d : devicesByConsumption) {
            if (d instanceof Fridge) {
                fridge = (Fridge) d;
                break;
            }
        }

        for (int i = 0; i < DAYS; i++) {
            simulateDay(house, people, pets);
            if (i == 3 || i == 10 || i == 20 || i == 45) {
                simulateRandomEvent(house);
            }
            if (fridge != null && fridge.isTurnedOn()) {
                fridge.getElectricityAPI().hashCode();
            }
        }

        ConsumptionReport consumptionReport = new ConsumptionReport(devicesByConsumption, 10, 1, folderForReports);
        consumptionReport.generateReport();
        EventReport eventReport = new EventReport(sensors, folderForReports);
        eventReport.generateReport();
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport(people, devicesByConsumption, sensors);
        activityAndUsageReport.generateReport();
    }

    private static void simulateDay(House house, List<Person> people, List<Pet> pets) {
        // Simulate activities during the day
    }

    private static void simulateFireEvent(House house) {
        Event event = new Event(EventType.FIRE);
        // Simulate fire event
    }

    private static void simulateWaterLeakEvent(House house) {
        Event event = new Event(EventType.WATER_LEAK);
        // Simulate water leak event
    }

    private static void simulatePowerOutageEvent(House house) {
        Event event = new Event(EventType.POWER_OUTAGE);
        // Simulate power outage event
    }

    private static Storey getRandomStorey(List<Storey> storeys) {
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
