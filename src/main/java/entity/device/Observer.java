package entity.device;

import entity.sensor.*;
import event.Event;

public interface Observer {


    void update(Event event, Sensor sensor);
}