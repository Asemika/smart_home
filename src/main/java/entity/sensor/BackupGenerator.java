/**
 * Represents a backup generator device.
 * This class extends the Device class and implements the Observer interface to receive notifications about events.
 */
package entity.sensor;

import entity.device.Device;
import entity.device.Observer;
import event.Event;
import event.EventType;

import java.util.ArrayList;
import java.util.List;

public class BackupGenerator extends Device implements Observer {
    private List<Device> devices = new ArrayList<>();

    /**
     * Constructs a BackupGenerator object and turns it on.
     */
    public BackupGenerator() {
        turnOn();
    }

    /**
     * Sets the list of devices connected to the backup generator.
     * @param devices The list of devices.
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * Adds a device to the list of devices connected to the backup generator.
     * @param device The device to add.
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Updates the state of the backup generator in response to an event.
     * If the event indicates a power outage, the backup generator turns on and all connected devices are turned on.
     * @param event The event triggering the update.
     * @param sensor The sensor associated with the event.
     */
    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType() == EventType.POWER_OUTAGE) {
            getActivityState().turnOn(this);
            System.out.println("Turning on all devices");
            for (Device device : devices) {
                device.turnOn();
            }
        }
    }
}
