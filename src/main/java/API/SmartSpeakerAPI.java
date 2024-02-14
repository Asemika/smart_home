package API;

import entity.device.Documentation;
import entity.device.SmartSpeaker;
import States.TurnedOnState;

/**
 * Provides an API for controlling a smart speaker.
 */
public class SmartSpeakerAPI implements FixAPI {
    SmartSpeaker smartSpeaker;

    /**
     * Constructs a SmartSpeakerAPI object.
     *
     * @param smartSpeaker the SmartSpeaker instance to control
     */
    public SmartSpeakerAPI(SmartSpeaker smartSpeaker) {
        this.smartSpeaker = smartSpeaker;
    }

    /**
     * Turns on the smart speaker.
     */
    public void turnOn() {
        smartSpeaker.turnOn();
    }

    /**
     * Turns off the smart speaker.
     */
    public void turnOff() {
        smartSpeaker.turnOff();
    }

    /**
     * Plays music on the smart speaker if it's turned on.
     */
    public void playMusic() {
        if (smartSpeaker.getActivityState() instanceof TurnedOnState) {
            smartSpeaker.playMusic();
        } else {
            System.out.println("Device is not turned on");
        }
    }

    /**
     * Changes the soundtrack to the next in the playlist if the smart speaker is turned on.
     */
    public void changeMusicForward() {
        if (smartSpeaker.getActivityState() instanceof TurnedOnState) {
            smartSpeaker.changeSoundtrackForward();
        } else {
            System.out.println("Device is not turned on");
        }
    }

    /**
     * Changes the soundtrack to the previous in the playlist if the smart speaker is turned on.
     */
    public void changeMusicBackward() {
        if (smartSpeaker.getActivityState() instanceof TurnedOnState) {
            smartSpeaker.changeSoundtrackBackward();
        } else {
            System.out.println("Device is not turned on");
        }
    }

    /**
     * Fixes the smart speaker.
     *
     * @param documentation the documentation needed to fix the smart speaker
     */
    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing SmartSpeaker");
        smartSpeaker.fixDevice();
    }

    /**
     * Retrieves the documentation for the smart speaker.
     *
     * @return the documentation for the smart speaker
     */
    public Documentation getDocumentation() {
        return smartSpeaker.getDocumentation();
    }
}
