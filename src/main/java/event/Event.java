package event;

public class Event {
    private String type;
    private String description;

    public Event(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}