package house;

import entity.device.Device;
import entity.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Device> devices;
    private List<Window> windows;
    private List<Sensor> sensors;

    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
        this.windows = new ArrayList<>();
        this.sensors = new ArrayList<>();
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

    public void addWindow(Window window) {
        windows.add(window);
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public List<Sensor> getSensors() {
        return sensors;
    }
}
