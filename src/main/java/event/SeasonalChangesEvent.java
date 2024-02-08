package event;

class SeasonalChangesEvent extends Event {
    private String season;

    public SeasonalChangesEvent(String season) {
        super("Seasonal changes event: It's now " + season + "!");
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void reactToSeason() {
        System.out.println("Adjusting to seasonal changes.");
    }
}