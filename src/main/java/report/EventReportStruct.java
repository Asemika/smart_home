package report;

import entity.device.Fridge;
import entity.device.Observer;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.StrongWindSensor;
import entity.sensor.WaterLeakSensor;
import event.Event;

import java.util.List;

public class EventReportStruct {
    private Event event;
    private WaterLeakSensor sourceSensor;
    private List<Observer> listeners;

    public EventReportStruct(Event event, WaterLeakSensor sourceSensor, List<Observer> listeners) {
        this.event = event;
        this.sourceSensor = sourceSensor;
        this.listeners = listeners;
    }

    public EventReportStruct(Event event, Fridge sourceSensor, List<Observer> listeners) {
    }

    public EventReportStruct(Event event, FireSensor sourceSensor, List<Observer> listeners) {
    }

    public EventReportStruct(Event event, PowerOutageSensor sourceSensor, List<Observer> listeners) {
    }

    public EventReportStruct(Event event, StrongWindSensor sourceSensor, List<Observer> listeners) {
    }

    public Event getEventType() {
        return event;
    }

    public WaterLeakSensor getSourceSensor() {
        return sourceSensor;
    }

    public List<Observer> getListeners() {
        return listeners;
    }
}