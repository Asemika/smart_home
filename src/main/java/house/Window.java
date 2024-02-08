package house;

import entity.device.Blinds;

public class Window {
    private boolean isOpen;
    private boolean hasShutter;

    public Window(boolean hasShutter) {
        this.isOpen = false;
        this.hasShutter = hasShutter;
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
    }
}
