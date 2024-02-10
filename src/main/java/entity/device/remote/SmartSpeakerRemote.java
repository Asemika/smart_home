package entity.device.remote;

import entity.device.SmartSpeaker;

/**
 * Represents a remote control for a smart speaker device.
 */
public class SmartSpeakerRemote {
    private SmartSpeaker smartSpeaker;

    /**
     * Constructs a new `SmartSpeakerRemote` object.
     *
     * @param smartSpeaker The smart speaker to be controlled by the remote.
     */
    public SmartSpeakerRemote(SmartSpeaker smartSpeaker) {
        this.smartSpeaker = smartSpeaker;
    }

    /**
     * Turns on the smart speaker using the remote.
     */
    public void turnOn() {
        smartSpeaker.turnOn();
    }

    /**
     * Turns off the smart speaker using the remote.
     */
    public void turnOff() {
        smartSpeaker.turnOff();
    }

    /**
     * Checks if the smart speaker is turned on.
     *
     * @return True if the smart speaker is turned on, false otherwise.
     */
    public boolean isSmartSpeakerTurnedOn() {
        return smartSpeaker.isTurnedOn(); // Accessing the public method to check the status
    }
}
