package API;

import java.util.ArrayList;

public class EventAPI {
    private final List<EventReportStruct> eventReportStructs = new ArrayList<>();

    public void addNewEventReportStruct(EventReportStruct eventReportStruct) {
        eventReportStructs.add(eventReportStruct);
    }

    public List<EventReportStruct> getEventReportStructs() {
        return eventReportStructs;
    }

}
