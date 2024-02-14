package systems;

import entity.device.Device;
import entity.device.Fridge;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.StrongWindSensor;
import event.Event;
import house.Room;

public class LightSystem extends Device {

    public LightSystem() {
    }



    public void turnLightOn(Room room) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        room.setLightIsOn(true);
    }

    public void turnLightOff(Room room) {
        room.setLightIsOn(false);
    }


}