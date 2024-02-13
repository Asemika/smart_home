package entity.device;

import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.StrongWindSensor;
import entity.sensor.WaterLeakSensor;
import event.Event;

public interface Observer {
    void update(Event event, WaterLeakSensor sensor); // sensor - source

    void update(Event event, Fridge fridge);

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyAllObservers(Event event);

    void update(Event event, FireSensor fireSensor);

    void update(Event event, PowerOutageSensor powerOutageSensor);

    void update(Event event, StrongWindSensor strongWindSensor);
}