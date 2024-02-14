package house;

import entity.device.Blinds;
import entity.device.DeviceType;
import entity.device.Open;

public class Window implements Open {
    private Blinds blinds = new Blinds();
    private Boolean isOpened = false;

    @Override
    public void open() {
        isOpened = true;
    }

    @Override
    public void close() {
        isOpened = false;
    }

    public Blinds getBlinds() {
        return blinds;
    }

    public void setBlinds(Blinds blinds) {
        this.blinds = blinds;
    }
}
