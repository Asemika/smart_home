package entity.device;

import entity.sensor.Sensor;
import event.Event;

public interface Observer {
    void update(Event event, Sensor sensor); // sensor - source
}