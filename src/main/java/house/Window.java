package house;

import entity.device.Blinds;
import entity.device.AirCondition;
import entity.device.DeviceType;


public class Window {
    private boolean isOpen;
    private boolean hasShutter;
    private Blinds blinds;

    public Window(boolean hasShutter) {
        this.isOpen = false;
        this.hasShutter = hasShutter;
        this.blinds = new Blinds("Living Room Blinds", DeviceType.BLINDS, 5.0, 2.0, 1.0);

    }

    public Window() {

    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
        System.out.println("Window is now open.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Window is now closed.");
    }

    public boolean hasShutter() {
        return hasShutter;
    }

    public Blinds getBlinds() {
        return blinds;
    }

    public void closeWindowsWhenAirConditionerOn() {
        if (AirCondition.isTurnedOn()) {
            close();
        }
    }
}
