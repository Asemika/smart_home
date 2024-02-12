package report;

import entity.device.Device;
import event.Event;

import java.util.List;

public class EventReport {
    private List<Event> events;

    public EventReport(List<Event> events) {
        this.events = events;
    }

    public EventReport(List<Device> sensors, String folderForReports) {

    }

    public void generateReport() {
        System.out.println("Event Report:");
        System.out.println("-------------");
        for (Event event : events) {
            System.out.println("Event: " + event.getDescription());
        }
    }
}