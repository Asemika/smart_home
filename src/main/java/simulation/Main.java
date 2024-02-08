package simulation;

import entity.creature.Pet;
import entity.device.Device;
import entity.creature.Person;
import house.House;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = Configuration.getInstance();
        House house = configuration.initHouse();
        List<Person> people = configuration.getPeople();
        List<Pet> pets = configuration.getPets();
        List<Device> devicesByConsumption = configuration.getDevicesWithConsumption();
        List<Device> sensors = configuration.getSensors();
        String folderForReports = "1";
        Simulation.startSimulation(house, people, pets, devicesByConsumption, sensors, folderForReports);

//        Configuration2 configuration2 = Configuration2.getInstance();
//        house = configuration2.initHouse();
//        people = configuration2.getPeople();
//        pets = configuration2.getPets();
//        devicesByConsumption = configuration2.getDevicesWithConsumption();
//        sensors = configuration2.getSensors();
//        folderForReports = "2";
//        startSimulation(house, people, pets, devicesByConsumption, sensors, folderForReports);
    }
}