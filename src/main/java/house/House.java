package house;

import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Floor> floors;
    private FireSystem fireSystem;
    private WaterLeakSystem waterLeakSystem;
    private List<Room> rooms;

    public House() {
        this.fireSystem = new FireSystem();
        this.waterLeakSystem = new WaterLeakSystem();
        this.rooms = new ArrayList<>();
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public FireSystem getFireSystem() {
        return fireSystem;
    }

    public WaterLeakSystem getWaterLeakSystem() {
        return waterLeakSystem;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean isEmpty() {
        return floors.isEmpty();
    }

    public Floor get(int index) {
        return floors.get(index);
    }

    public int size() {
        return floors.size();
    }
}
