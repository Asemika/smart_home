package report;

import entity.device.Fridge;
import entity.device.Observer;
import entity.sensor.*;
import event.Event;

import java.util.List;

public class EventReportStruct {
    private Event event;
    private Sensor sourceSensor;
    private List<Observer> listeners;

    public EventReportStruct(Event event, Sensor sourceSensor, List<Observer> listeners) {
        this.event = event;
        this.sourceSensor = sourceSensor;
        this.listeners = listeners;
    }

    public Event getEventType() {
        return event;
    }

    public Sensor getSourceSensor() {
        return sourceSensor;
    }

    public List<Observer> getListeners() {
        return listeners;
    }
}