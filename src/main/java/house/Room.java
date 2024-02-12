package house;

import java.util.ArrayList;
import java.util.List;

import entity.device.Device;
import house.Window;
import entity.device.Blinds;
import entity.sensor.Sensor;

public class Room {
    private String name;
    private List<Device> devices;
    private List<Sensor> sensors;
    private List<Window> windows;

    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
        this.sensors = new ArrayList<>();
        this.windows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void addWindow(Window window) {
        windows.add(window);
    }

    public List<Window> getWindows() {
        return windows;
    }

    public List<Blinds> getAllBlinds() {
        List<Blinds> blinds = new ArrayList<>();
        for (Window window : windows) {
            blinds.add(window.getBlinds());
        }
        return blinds;
    }
}
