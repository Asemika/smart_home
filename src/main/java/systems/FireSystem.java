package systems;

import entity.device.AirCondition;
import entity.device.Device;
import entity.device.Fridge;
import entity.device.Observer;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.StrongWindSensor;
import entity.sensor.WaterLeakSensor;
import event.Event;
import event.EventType;

public class FireSystem extends Device implements Observer {

    @Override
    public void update(Event event, WaterLeakSensor sensor) {
        if (event.getEventType() == EventType.FIRE) System.out.println("The extinguishing system was launched");
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

    @Override
    public void update(Event event, AirCondition airCondition) {

    }
}