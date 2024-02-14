/**
 * Represents a TV device.
 * This class extends the Device class and provides functionality specific to a TV, such as changing channels and watching TV.
 */
package entity.device;

import event.Event;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class TV extends Device {
    private final List<String> channels = new ArrayList<>();
    private int indexOfCurrentChannel = 0;

    /**
     * Constructs a TV object.
     */
    public TV() {
    }

    /**
     * Gets the index of the current channel.
     * @return The index of the current channel.
     */
    public int getIndexOfCurrentChannel() {
        return indexOfCurrentChannel;
    }

    /**
     * Sets the index of the current channel.
     * @param indexOfCurrentChannel The index of the current channel to set.
     */
    public void setIndexOfCurrentChannel(int indexOfCurrentChannel) {
        this.indexOfCurrentChannel = indexOfCurrentChannel;
    }

    /**
     * Gets the list of channels.
     * @return The list of channels.
     */
    public List<String> getChannels() {
        return channels;
    }

    /**
     * Changes to the next channel in the list.
     */
    public void changeChannelForward() {
        if (indexOfCurrentChannel == channels.size() - 1) {
            indexOfCurrentChannel = 0;
        } else indexOfCurrentChannel += 1;
    }

    /**
     * Changes to the previous channel in the list.
     */
    public void changeChannelBackward() {
        if (indexOfCurrentChannel == 0) {
            indexOfCurrentChannel = channels.size() - 1;
        } else indexOfCurrentChannel -= 1;
    }

    /**
     * Watches TV.
     */
    public void watchTV() {
        getElectricityAPI().increaseCounter(getkWPerHour());
    }
}
