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

public class WaterLeakSystem extends Device implements Observer {

    @Override
    public void update(Event event, WaterLeakSensor sensor) {
        if (EventType.WATER_LEAK == event.getEventType())
            System.out.println("The water has stopped flowing into the house");
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