package house;

import entity.creature.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a floor in a building.
 */
public class Floor {
    private List<Person> peopleOnFloor = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    /**
     * Adds a room to the floor.
     * @param room The room to add.
     * @return The Floor object with the added room.
     */
    public Floor addRoom(Room room) {
        rooms.add(room);
        return this;
    }

    /**
     * Gets the list of rooms on the floor.
     * @return The list of rooms.
     */
    public List<Room> getRooms() {
        return rooms;
    }
}
