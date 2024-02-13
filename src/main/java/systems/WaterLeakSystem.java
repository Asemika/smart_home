package systems;

import entity.device.Device;
import entity.device.Observer;
import entity.sensor.WaterLeakSensor;
import event.Event;
import event.EventType;

public class WaterLeakSystem extends Device implements Observer {

    @Override
    public void update(Event event, WaterLeakSensor sensor) {
        if (event.getEventType() == EventType.WATER_LEAK) {
            System.out.println("The water has stopped flowing into the house");
        }
    }


    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }
}