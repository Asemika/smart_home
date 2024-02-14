package event;

public class Event {
    private final EventType eventType;

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }
}
//    private String type;
//    private String description;
//
//    public Event(String type, String description) {
//        this.type = type;
//        this.description = description;
//    }
//
//    public Event(String brokenDevice) {
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void getEventType() {
//        // Předpokládám, že pokud je typ události prázdný nebo null, nebo pokud je roven "brokenDevice", jedná se o poruchu zařízení
//        return !type.isEmpty() && !type.equalsIgnoreCase("brokenDevice");
//    }

