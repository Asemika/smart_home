package entity.creature;

import house.Room;

import java.util.List;
import java.util.Random;

/**
 * Represents a pet creature in the house.
 */
public class Pet extends Creature {
    private Room currRoom;
    private String type;

    /**
     * Constructs a pet with the given name, room, and type.
     *
     * @param name the name of the pet
     * @param room the room where the pet is initially located
     * @param type the type of the pet
     */
    public Pet(String name, Room room, String type) {
        super(name, room);
        this.currRoom = room;
        this.type = type;
    }

    /**
     * Constructs a pet with the given room and type.
     *
     * @param room the room where the pet is initially located
     * @param cat  the type of the pet
     */
    public Pet(Room room, String cat) {
        super(cat, room);
        this.currRoom = room;
        this.type = type;
    }

    /**
     * Gets the type of the pet.
     *
     * @return the type of the pet
     */
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
     * Moves the pet to another random room on the storey.
     *
     * @param rooms the list of rooms where the pet can move
     */
    public void changeRoom(List<Room> rooms) {
        Random random = new Random();
        int randRoomIndex = random.nextInt(rooms.size());
        currRoom = rooms.get(randRoomIndex);
    }
}
