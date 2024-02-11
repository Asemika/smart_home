package house;

import java.util.ArrayList;
import java.util.List;

public class Storey {
    private List<Room> rooms;

    public Storey() {
        this.rooms = new ArrayList<>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // Method to add a room to the storey
    public void addRoom(Room room) {
        rooms.add(room);
    }
}
