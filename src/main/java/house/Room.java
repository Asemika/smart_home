package house;

import java.util.ArrayList;
import java.util.List;

import entity.device.Device;
import entity.sensor.FireSensor;
import entity.sensor.Sensor;

/**
 * Represents a room in a house.
 */
public class Room {
    /**
     * The type of the room.
     */
    private RoomType type;

    /**
     * The list of windows in the room.
     */
    private List<Window> windows;

    /**
     * The list of devices in the room.
     */
    private List<Device> devices;

    /**
     * The list of fire sensors in the room.
     */
    private List<FireSensor> fireSensors;

    /**
     * Constructs a new Room object with the specified parameters.
     *
     * @param type               The type of the room.
     * @param numberOfWindows   The number of windows in the room.
     * @param windowsHaveShutter A boolean indicating whether the windows have shutters.
     */
    public Room(RoomType type, int numberOfWindows, boolean windowsHaveShutter) {
        this.type = type;
        this.windows = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.fireSensors = new ArrayList<>();
        initializeWindows(numberOfWindows, windowsHaveShutter);
    }
    private void initializeWindows(int numberOfWindows, boolean windowsHaveShutter) {
        for (int i = 0; i < numberOfWindows; i++) {
            Window window = new Window(windowsHaveShutter);
            windows.add(window);
        }
    }

    /**
     * Returns the type of the room.
     *
     * @return The type of the room.
     */
    public RoomType getType() {
        return type;
    }

    /**
     * Returns the list of windows in the room.
     *
     * @return The list of windows in the room.
     */
    public List<Window> getWindows() {
        return windows;
    }

    /**
     * Adds a device to the room.
     *
     * @param device The device to add to the room.
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Returns the list of devices in the room.
     *
     * @return The list of devices in the room.
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Adds a window to the room.
     *
     * @param window The window to add to the room.
     */
    public void addWindow(Window window) {
        windows.add(window);
    }

    /**
     * Adds a fire sensor to the room.
     *
     * @param fireSensor The fire sensor to add to the room.
     */
    public void addSensor(FireSensor fireSensor) {
        fireSensors.add(fireSensor);
    }

    /**
     * Returns an iterable of all sensors in the room.
     *
     * @return An iterable of all sensors in the room.
     */
    public Iterable<? extends Sensor> getSensors() {
        return fireSensors;
    }
}
