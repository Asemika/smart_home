package house;

import entity.creature.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a floor in a building.
 */
import java.util.ArrayList;
import java.util.List;

public class Floor {
    List<Person> peopleOnFloor = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();


    public Floor addRoom(Room room) {
        rooms.add(room);
        return this;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}