package event;

import java.util.Date;

/**
 * Represents a cooking event in the smart home system.
 */
public class CookingEvent {
    private final String eventName;
    private final Date startTime;
    private final String dishName;

    /**
     * Constructs a CookingEvent with the specified details.
     * @param eventName The name of the cooking event.
     * @param startTime The start time of the cooking event.
     * @param dishName The name of the dish being prepared.
     */
    public CookingEvent(String eventName, Date startTime, String dishName) {
        this.eventName = eventName;
        this.startTime = startTime;
        this.dishName = dishName;
    }


    /**
     * Gets the start time of the cooking event.
     * @return The start time.
     */
    public Date getStartTime() {
        return startTime;
    }
}
