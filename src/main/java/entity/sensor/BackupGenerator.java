package entity.sensor;

import entity.device.Device;
import entity.device.Fridge;
import entity.device.Observer;
import event.Event;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class BackupGenerator extends Device  {
    private List<Device> devices = new ArrayList<>();

    public void BackupGenerator() {
        turnOn();
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

}