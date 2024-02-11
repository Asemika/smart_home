package house;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a floor in a building.
 */
public class Floor {
    private List<Room> rooms;

    /**
     * Constructs a new Floor object.
     */
    public Floor() {
        this.rooms = new ArrayList<>();
    }

    /**
     * Adds a room to the floor.
     *
     * @param room The room to add.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Gets the list of rooms on the floor.
     *
     * @return The list of rooms.
     */
    public List<Room> getRooms() {
        return rooms;
    }
}
