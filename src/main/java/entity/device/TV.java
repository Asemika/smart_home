package entity.device;

public class TV extends Device {
    private int currentChannel;

    public TV() {
        super("TV", DeviceType.TV, 20.0, 10.0, 5.0);
        this.currentChannel = 1;  // Default initial channel
    }

    public void changeChannel(int newChannel) {
        this.currentChannel = newChannel;
        System.out.println("TV channel changed to " + newChannel);
    }

    public void adjustVolume(int volumeLevel) {
        System.out.println("TV volume adjusted to level " + volumeLevel);
    }
}

