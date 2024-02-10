package house;

import jdk.internal.icu.text.UnicodeSet;
import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Floor> floors;
    private FireSystem fireSystem;
    private WaterLeakSystem waterLeakSystem;
    private UnicodeSet rooms;

    public House() {
        this.floors = new ArrayList<>();
        this.fireSystem = new FireSystem();
        this.waterLeakSystem = new WaterLeakSystem();
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

    public FireSystem getBackupGenerator() {
    }

    public void addStorey(Storey storey) {
    }

    public House addRoom(Room room) {
        rooms.add(room);
        return this;
    }

    public House getStoreys() {
    }

    public boolean isEmpty() {
    }

    public Storey get(int nextInt) {
    }

    public int size() {
        return 0;
    }
}
