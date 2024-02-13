package States;

import entity.device.Device;

public interface BreakdownsState {
    void fixDevice(Device device);

    void breakDevice(Device device);


}
