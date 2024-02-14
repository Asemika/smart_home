/**
 * Represents a smart speaker device.
 * This class extends the Device class and provides functionality specific to a smart speaker, such as playing music.
 */
package entity.device;

import event.Event;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class SmartSpeaker extends Device {
    private final List<String> musicPlaylist = new ArrayList<>();
    private int indexOfCurrentMusicPlaylist = 0;

    /**
     * Constructs a SmartSpeaker object.
     */
    public SmartSpeaker() {
    }

    /**
     * Gets the music playlist.
     * @return The music playlist.
     */
    public List<String> getMusicPlaylist() {
        return musicPlaylist;
    }

    /**
     * Adds music to the playlist.
     * @param music The music to add.
     */
    public void addMusic(String music) {
        musicPlaylist.add(music);
    }

    /**
     * Plays music.
     */
    public void playMusic() {
        getElectricityAPI().increaseCounter(getkWPerHour());
    }

    /**
     * Changes to the next soundtrack in the playlist.
     */
    public void changeSoundtrackForward() {
        if (indexOfCurrentMusicPlaylist == musicPlaylist.size() - 1) {
            indexOfCurrentMusicPlaylist = 0;
        } else {
            indexOfCurrentMusicPlaylist++;
        }
    }

    /**
     * Changes to the previous soundtrack in the playlist.
     */
    public void changeSoundtrackBackward() {
        if (indexOfCurrentMusicPlaylist == 0) {
            indexOfCurrentMusicPlaylist = musicPlaylist.size() - 1;
        } else {
            indexOfCurrentMusicPlaylist--;
        }
    }
}
