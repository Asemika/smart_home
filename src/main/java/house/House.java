package house;

import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Storey> storeys;
    private FireSystem fireSystem;
    private WaterLeakSystem waterLeakSystem;
    private List<Room> rooms;

    public House() {
        this.storeys = new ArrayList<>();
        this.fireSystem = new FireSystem();
        this.waterLeakSystem = new WaterLeakSystem();
        this.rooms = new ArrayList<>();
    }

    public void addStorey(Storey storey) {
        storeys.add(storey);
    }

    public List<Storey> getStoreys() {
        return storeys;
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
        return storeys.isEmpty();
    }

    public Storey get(int index) {
        return storeys.get(index);
    }

    public int size() {
        return storeys.size();
    }
}
