package house;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Room> rooms;

    public Floor() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}