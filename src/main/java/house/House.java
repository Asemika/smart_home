package house;

import entity.sensor.BackupGenerator;
import systems.FireSystem;
import systems.LightSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a house.
 */
public class House {
    private List<Floor> floors = new ArrayList<>();
    private LightSystem lightSystem = new LightSystem();
    private FireSystem fireSystem = new FireSystem();
    private WaterLeakSystem waterLeakSystem = new WaterLeakSystem();
    private BackupGenerator backupGenerator = new BackupGenerator();

    /**
     * Constructs a new House object.
     */
    public House() {

    }

    /**
     * Gets the list of floors in the house.
     * @return The list of floors.
     */
    public List<Floor> getFloors() {
        return floors;
    }

    /**
     * Sets the list of floors in the house.
     * @param floors The list of floors to set.
     */
    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    /**
     * Adds a floor to the house.
     * @param floor The floor to add.
     */
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    /**
     * Gets the light system of the house.
     * @return The light system.
     */
    public LightSystem getLightSystem() {
        return lightSystem;
    }

    /**
     * Sets the light system of the house.
     * @param lightSystem The light system to set.
     */
    public void setLightSystem(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    /**
     * Gets the fire system of the house.
     * @return The fire system.
     */
    public FireSystem getFireSystem() {
        return fireSystem;
    }

    /**
     * Sets the fire system of the house.
     * @param fireSystem The fire system to set.
     */
    public void setFireSystem(FireSystem fireSystem) {
        this.fireSystem = fireSystem;
    }

    /**
     * Gets the water leak system of the house.
     * @return The water leak system.
     */
    public WaterLeakSystem getWaterLeakSystem() {
        return waterLeakSystem;
    }

    /**
     * Sets the water leak system of the house.
     * @param waterLeakSystem The water leak system to set.
     */
    public void setWaterLeakSystem(WaterLeakSystem waterLeakSystem) {
        this.waterLeakSystem = waterLeakSystem;
    }

    /**
     * Gets the backup generator of the house.
     * @return The backup generator.
     */
    public BackupGenerator getBackupGenerator() {
        return backupGenerator;
    }

    /**
     * Sets the backup generator of the house.
     * @param backupGenerator The backup generator to set.
     */
    public void setBackupGenerator(BackupGenerator backupGenerator) {
        this.backupGenerator = backupGenerator;
    }

}
