package API;

import entity.device.Documentation;
import entity.device.SmartSpeaker;
import States.TurnedOnState;

public class SmartSpeakerAPI  {
    SmartSpeaker smartSpeaker;

    public SmartSpeakerAPI(SmartSpeaker smartSpeaker) {
        this.smartSpeaker = smartSpeaker;
    }

    public void turnOn() {
        smartSpeaker.turnOn();
    }

    public void turnOff() {
        smartSpeaker.turnOff();
    }

    /**
     * person turns on music on smart speaker.
     */
    public void playMusic() {
        if (smartSpeaker.getActivityState() instanceof TurnedOnState) {
            smartSpeaker.playMusic();
        } else System.out.println("device is not turned on");

    }

    /**
     * changes soundtrack on the next in the playlist.
     */
    public void changeMusicForward() {
        if (smartSpeaker.getActivityState() instanceof TurnedOnState) {
            smartSpeaker.changeSoundtrackForward();
        } else System.out.println("device is not turned on");

    }

    /**
     * changes soundtrack on the previous in the playlist.
     */
    public void changeMusicBackward() {
        if (smartSpeaker.getActivityState() instanceof TurnedOnState) {
            smartSpeaker.changeSoundtrackBackward();
        } else System.out.println("device is not turned on");

    }

    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing SmartSpeaker");
        smartSpeaker.fixDevice();

    }

    public Documentation getDocumentation() {
        return smartSpeaker.getDocumentation();
    }
}