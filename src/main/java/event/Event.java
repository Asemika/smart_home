package event;

public class Event {
    private final EventType eventType;

    public Event(String eventType) {
        this.eventType = EventType.valueOf(eventType);
    }

    public EventType getEventType() {
        return eventType;
    }
}
