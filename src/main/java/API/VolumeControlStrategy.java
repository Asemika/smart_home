package API;

public interface VolumeControlStrategy {
    void adjustVolume(int volumeLevel);
    void mute();
}
