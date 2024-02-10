package entity.device.remote;

import entity.device.TV;

public class TVRemote {

    private TV tv;

    public TVRemote(TV tv) {
        this.tv = tv;
    }

    public void pressPowerButton() {
        if (tv.isTurnedOn()) {
            tv.turnOff();
            System.out.println("TV turned off using remote control.");
        } else {
            tv.turnOn();
            System.out.println("TV turned on using remote control.");
        }
    }

    public void pressVolumeUp() {
        tv.adjustVolume(5); // Increase volume by 5 units
    }

    public void pressVolumeDown() {
        tv.adjustVolume(-5); // Decrease volume by 5 units
    }
}
