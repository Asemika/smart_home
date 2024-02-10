package house;

import entity.device.Device;
import entity.sensor.FireSensor;
import entity.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
public class Room {
    private String name;
    private List<Window> windows;
    private List<Device> devices;
    public Room(String name, int numberOfWindows, boolean windowsHaveShutter) {
        this.name = name;
        this.windows = new ArrayList<>();
        this.devices = new ArrayList<>();
        initializeWindows(numberOfWindows, windowsHaveShutter);
    }


    public Room(String room) {
    }

    private void initializeWindows(int numberOfWindows, boolean windowsHaveShutter) {
        for (int i = 0; i < numberOfWindows; i++) {
            Window window = new Window(windowsHaveShutter);
            windows.add(window);
        }
    }

    public String getName() {
        return name;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addWindow(Window window) {
    }

    public void addSensor(FireSensor fireSensor) {
    }

    public Iterable<? extends Sensor> getSensors() {
        return null;
    }
}