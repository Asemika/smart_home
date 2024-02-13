package entity.device;

import event.Event;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class SmartSpeaker extends Device {
        private final List<String> musicPlaylist = new ArrayList<>();
        private int indexOfCurrentMusicPlaylist = 0;

        public SmartSpeaker() {
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

    public List<String> getMusicPlaylist() {
            return musicPlaylist;
        }

        public void addMusic(String music) {
            musicPlaylist.add(music);
        }

        public void playMusic() {
            getElectricityAPI().increaseCounter(getkWPerHour());
        }

        public void changeSoundtrackForward() {
            if (indexOfCurrentMusicPlaylist == musicPlaylist.size() - 1) {
                indexOfCurrentMusicPlaylist = 0;
            } else {
                indexOfCurrentMusicPlaylist++;
            }
        }

        public void changeSoundtrackBackward() {
            if (indexOfCurrentMusicPlaylist == 0) {
                indexOfCurrentMusicPlaylist = musicPlaylist.size() - 1;
            } else {
                indexOfCurrentMusicPlaylist--;
            }
        }

    @Override
    public void update(Event event, Fridge fridge) {

    }
}
