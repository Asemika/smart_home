package event;

public enum EventType {
    ;
    public static final String FIRE = "FIRE";
    public static final String WATER_LEAK = "WATER_LEAK";
    public static final String POWER_OUTAGE ="POWER_OUTAGE" ;
    public static final String BROKEN_DEVICE ="BROKEN_DEVICE" ;
    public static final String STRONG_WIND ="STRONG_WIND" ;
    private final String type;

    EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
