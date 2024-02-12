package simulation;

import entity.creature.Pet;
import entity.device.Device;
import entity.creature.Person;
import entity.sensor.WaterLeakSensor;
import house.House;

import java.util.List;

import static simulation.Simulation.startSimulation;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = Configuration.getInstance();
        House house = configuration.initHouse();
        List<Person> people = configuration.getPeople();
        List<Pet> pets = configuration.getPets();
        List<WaterLeakSensor> devicesByConsumption = configuration.getDevicesWithConsumption();
        List<WaterLeakSensor> sensors = configuration.getSensors();
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

    private static void startSimulation(House house, List<Person> people, List<Pet> pets, List<WaterLeakSensor> devicesByConsumption, List<WaterLeakSensor> sensors, String folderForReports) {
    }
}