package entity.sensor;

public class Sensor {
    private SensorType type;
    private boolean isWorking;

    public Sensor(SensorType type) {
        this.type = type;
        this.isWorking = true;
    }

    public SensorType getType() {
        return type;
    }

    public boolean isWorking() {
        return isWorking;
    }

}
