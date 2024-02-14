package entity.sensor;

import entity.device.Observer;
import event.Event;

public interface Sensor {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyAllObservers(Event event);
}