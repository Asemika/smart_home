package entity.device;

import entity.device.interfaces.VolumeControlStrategy;

public class TV extends Device {
    private int currentChannel;
    private VolumeControlStrategy volumeControlStrategy;

    public TV() {
        super("TV", DeviceType.TV, 20.0, 10.0, 5.0);
        this.currentChannel = 1;  // Default initial channel
    }

    public void changeChannel(int newChannel) {
        this.currentChannel = newChannel;
        System.out.println("TV channel changed to " + newChannel);
    }

    public void adjustVolume(int volumeLevel) {
        if (volumeControlStrategy != null) {
            volumeControlStrategy.adjustVolume(volumeLevel);
        } else {
            System.out.println("No volume control strategy set for TV.");
        }
    }

    public void setVolumeControlStrategy(VolumeControlStrategy volumeControlStrategy) {
        this.volumeControlStrategy = volumeControlStrategy;
    }

    public void setVolumeMute() {
        if (volumeControlStrategy != null) {
            volumeControlStrategy.mute();
        } else {
            System.out.println("No volume control strategy set for TV.");
        }
    }
}

