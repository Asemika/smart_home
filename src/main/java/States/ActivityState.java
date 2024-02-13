package States;

import entity.device.Device;

public interface ActivityState {
    void turnOn(Device device);

    void turnOff(Device device);
}