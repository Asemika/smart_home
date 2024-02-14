package systems;

import entity.device.AirCondition;
import entity.device.Device;
import entity.device.Fridge;
import entity.device.Observer;
import entity.sensor.*;
import event.Event;
import event.EventType;

public class WaterLeakSystem extends Device implements Observer {
    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType() == EventType.WATER_LEAK) {
            System.out.println("The water has stopped flowing into the house");
        }
    }
}