package API;

import entity.device.Documentation;

public interface FixAPI {
    /**
     * fixes device but only with documentation which you can get  from device
     *
     * @param documentation
     */
    void fixDevice(Documentation documentation);
}