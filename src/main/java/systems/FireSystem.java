package systems;

import entity.device.Device;
import entity.device.Observer;
import entity.sensor.WaterLeakSensor;
import event.Event;
import event.EventType;

public class FireSystem extends Device implements Observer {

    @Override
    public void update(Event event, WaterLeakSensor sensor) {
        if (event.getEventType() == EventType.FIRE) {
            System.out.println("The extinguishing system was launched");
        }
    }
}