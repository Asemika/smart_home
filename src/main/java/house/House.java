package house;

import entity.device.Light;
import entity.sensor.BackupGenerator;
//import entity.sensor.Light;
//import entity.sensor.WaterLeakSystem;
import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Floor> floors = new ArrayList<>();
    private Light lightSystem = new Light();
    private FireSystem fireSystem = new FireSystem();
    private WaterLeakSystem waterLeakSystem = new WaterLeakSystem();
    private BackupGenerator backupGenerator = new BackupGenerator();

    public House() {

    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public Light getLightSystem() {
        return lightSystem;
    }

    public void setLightSystem(Light lightSystem) {
        this.lightSystem = lightSystem;
    }

    public FireSystem getFireSystem() {
        return fireSystem;
    }

    public void setFireSystem(FireSystem fireSystem) {
        this.fireSystem = fireSystem;
    }

    public WaterLeakSystem getWaterLeakSystem() {
        return waterLeakSystem;
    }

    public void setWaterLeakSystem(WaterLeakSystem waterLeakSystem) {
        this.waterLeakSystem = waterLeakSystem;
    }

//    public FireSystem getBackupGenerator() {
//        return backupGenerator;
//    }

    public void setBackupGenerator(BackupGenerator backupGenerator) {
        this.backupGenerator = backupGenerator;
    }
}