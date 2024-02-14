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

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void increaseTemp(int temp) {

    }

    @Override
    public void decreaseTemp(int temp) {

    }

    public void turnLightOn(Room room) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        room.setLightIsOn(true);
    }

    public void turnLightOff(Room room) {
        room.setLightIsOn(false);
    }

    @Override
    public void update(Event event, Fridge fridge) {

    }

    @Override
    public void update(Event event, FireSensor fireSensor) {

    }

    @Override
    public void update(Event event, PowerOutageSensor powerOutageSensor) {

    }

    @Override
    public void update(Event event, StrongWindSensor strongWindSensor) {

    }
}