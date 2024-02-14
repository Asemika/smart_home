package API;

import report.EventReportStruct;

import java.util.ArrayList;
import java.util.List;

/**
 * The EventAPI class manages event reports.
 */
public class EventAPI {
    private final List<EventReportStruct> eventReportStructs = new ArrayList<>();

    /**
     * Adds a new event report structure to the list.
     *
     * @param eventReportStruct the event report structure to add
     */
    public void addNewEventReportStruct(EventReportStruct eventReportStruct) {
        eventReportStructs.add(eventReportStruct);
    }

    /**
     * Gets the list of event report structures.
     *
     * @return the list of event report structures
     */
    public List<EventReportStruct> getEventReportStructs() {
        return eventReportStructs;
    }
}
