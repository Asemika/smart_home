package entity.device;
import event.Event;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class TV extends Device {
    private final List<String> channels = new ArrayList<>();
    private int indexOfCurrentChannel = 0;

    public TV() {
    }

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void increaseTemp(int temp) {

    }

    @Override
    public void decreaseTemp(int temp) {

    }

    public int getIndexOfCurrentChannel() {
        return indexOfCurrentChannel;
    }

    public void setIndexOfCurrentChannel(int indexOfCurrentChannel) {
        this.indexOfCurrentChannel = indexOfCurrentChannel;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void changeChannelForward() {
        if (indexOfCurrentChannel == channels.size() - 1) {
            indexOfCurrentChannel = 0;
        } else indexOfCurrentChannel += 1;
    }

    public void changeChannelBackward() {
        if (indexOfCurrentChannel == 0) {
            indexOfCurrentChannel = channels.size() - 1;
        } else indexOfCurrentChannel -= 1;
    }

    public void watchTV() {
        getElectricityAPI().increaseCounter(getkWPerHour());
    }

    @Override
    public void update(Event event, Fridge fridge) {

    }
}