package report;

import entity.creature.Person;
import entity.creature.Pet;
import house.Floor;
import house.House;
import house.Room;

import java.util.List;

public class HouseConfigurationReport {
    private House house;

    public HouseConfigurationReport(House house, List<Person> people, List<Pet> pets, String folderForReports) {
        this.house = house;
    }

    public void generateReport() {
        System.out.println("House Configuration Report:");
        System.out.println("--------------------------");
        System.out.println("Floors:");
        for (Floor floor : house.getFloors()) {
            System.out.println("- Floor with " + floor.getRooms().size() + " rooms");
            for (Room room : floor.getRooms()) {
                System.out.println("  - Room: " + room.getName() + " with " + room.getWindows().size() + " windows");
            }
        }
    }
}
