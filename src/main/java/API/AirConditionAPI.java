package API;

import entity.device.AirCondition;
import entity.device.Device;
import entity.device.Documentation;
import house.Room;
import States.TurnedOnState;

import java.util.List;

public class AirConditionAPI implements FixAPI {
    List<AirCondition> airConditions;

    public AirConditionAPI(List<AirCondition> airConditions) {
        this.airConditions = airConditions;
    }

    /**
     * turns on air condition in room.
     *
     * @param room
     */
    public void turnOn(Room room) {
        for (Device d : room.getDevices()) {
            if (d instanceof AirCondition) {
                d.turnOn();
            }
        }
    }

    /**
     * turns off air condition in room.
     *
     * @param room
     */
    public void turnOff(Room room) {
        for (Device d : room.getDevices()) {
            if (d instanceof AirCondition) {
                d.turnOn();
            }
        }
    }


    /**
     * increases temperature in some room on temp.
     *
     * @param temp
     * @param room
     */
    public void increaseTemp(int temp, Room room) {
        for (Device d : room.getDevices()) {
            if (d instanceof AirCondition) {
                if (d.getActivityState() instanceof TurnedOnState) {
                    ((AirCondition) d).increaseTemp(temp);
                } else {
                    System.out.println("Air conditioner is not turned on.");
                }
                return;
            }
        }
        System.out.println("No air conditioner found in the room.");
    }

    /**
     * decreases temperature in some room on temp.
     *
     * @param temp
     * @param room
     */
    public void decreaseTemp(int temp, Room room) {
        for (Device d : room.getDevices()) {
            if (d instanceof AirCondition) {
                if (d.getActivityState() instanceof TurnedOnState) {
                    ((AirCondition) d).decreaseTemp(temp);
                } else {
                    System.out.println("Air conditioner is not turned on.");
                }
                return;
            }
        }
        System.out.println("No air conditioner found in the room.");
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing air condition");
        for (AirCondition airCondition : airConditions) {
            airCondition.fixDevice();
        }
    }

    /**
     * @return documentation of device.
     */
    public Documentation getDocumentation() {
        return airConditions.get(0).getDocumentation();
    }
}