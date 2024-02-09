package entity.device.interfaces;

public interface VolumeControlStrategy {
    void adjustVolume(int volumeLevel);
    void mute();
}
