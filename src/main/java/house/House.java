package house;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Floor> floors;

    public House() {
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public FireSystem getFireSystem() {
    }

    public WaterLeakSystem getWaterLeakSystem() {
    }
}
