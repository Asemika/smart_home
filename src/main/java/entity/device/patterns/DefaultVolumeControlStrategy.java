package entity.device.patterns;

import entity.device.interfaces.VolumeControlStrategy;

public class DefaultVolumeControlStrategy implements VolumeControlStrategy {
    @Override
    public void adjustVolume(int volumeLevel) {
        System.out.println("TV volume adjusted to level " + volumeLevel);
    }

    @Override
    public void mute() {
        System.out.println("TV volume muted");
    }
}
