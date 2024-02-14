package house;

import entity.device.Device;
import entity.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in a house.
 */
public class Room {
    private final List<Sensor> sensors = new ArrayList<>();
    private final List<Window> windows = new ArrayList<>();
    private final List<Device> devices = new ArrayList<>();
    private final int temp = 24;
    private boolean lightIsOn = false;

    private String name;
    private String roomName;

    /**
     * Constructs a new Room object with the specified name.
     * @param name The name of the room.
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     * Sets whether the light is on in the room.
     * @param lightIsOn True if the light is on, false otherwise.
     */
    public void setLightIsOn(boolean lightIsOn) {
        this.lightIsOn = lightIsOn;
    }

    /**
     * Adds a device to the room.
     * @param device The device to add.
     * @return The updated Room object.
     */
    public Room addDevice(Device device) {
        devices.add(device);
        return this;
    }

    /**
     * Adds a sensor to the room.
     * @param sensor The sensor to add.
     */
    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    /**
     * Adds a window to the room.
     * @param window The window to add.
     * @return The updated Room object.
     */
    public Room addWindow(Window window) {
        windows.add(window);
        return this;
    }

    /**
     * Gets the list of windows in the room.
     * @return The list of windows.
     */
    public List<Window> getWindows() {
        return windows;
    }

    /**
     * Gets the list of devices in the room.
     * @return The list of devices.
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Gets the list of sensors in the room.
     * @return The list of sensors.
     */
    public List<Sensor> getSensors() {
        return sensors;
    }

    /**
     * Gets the name of the room.
     * @return The room name.
     */
    public String getRoomName() {
        return roomName;
    }
}
