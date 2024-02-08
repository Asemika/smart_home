package activities;

public class Activity {
    private String name;
    private activities.ActivityType type;

    public Activity(String name, activities.ActivityType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public activities.ActivityType getType() {
        return type;
    }

}
