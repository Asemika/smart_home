package entity.sensor;

import systems.FireSystem;

public abstract class FireSensor extends Sensor {
    private static final SensorType type = SensorType.FIRE; // Укажите конкретное значение для type

    private FireSystem fireSystem;

    public FireSensor() {
        super(type);
    }

    public void attach(FireSystem fireSystem) {
        this.fireSystem = fireSystem;
        System.out.println("FireSensor attached to FireSystem.");
    }
}
