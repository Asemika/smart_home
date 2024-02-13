package entity.creature;

import house.Room;

import java.util.List;
import java.util.List;
import java.util.Random;

public class Pet extends Creature {
    private Room currRoom;
    private final String type;

    public Pet(Room room, String type) {
        this.currRoom = room;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void doRandomActivity() {

    }

    @Override
    public void reactToEmergency() {

    }

    /**
     * moves pet to another random room on the storey.
     *
     * @param rooms
     */
    public void changeRoom(List<Room> rooms) {
        Random random = new Random();
        int randRoomIndex = random.nextInt(rooms.size());
        currRoom = rooms.get(randRoomIndex);
    }
}