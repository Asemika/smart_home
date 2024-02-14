package entity.creature;

import house.Room;

import java.util.List;

/**
 * Represents a generic creature in the house.
 */
public abstract class Creature {
    private String name;
    private Room currentRoom;

    /**
     * Constructs a Creature object with a given name and initial room.
     *
     * @param name        the name of the creature
     * @param initialRoom the initial room where the creature is located
     */
    public Creature(String name, Room initialRoom) {
        this.name = name;
        this.currentRoom = initialRoom;
    }

    /**
     * Performs a random activity specific to the creature.
     */
    public abstract void doRandomActivity();

    /**
     * Reacts to an emergency situation in the house.
     */
    public abstract void reactToEmergency();

    /**
     * Changes the room where the creature is located.
     *
     * @param rooms the list of rooms the creature can move to
     */
    public abstract void changeRoom(List<Room> rooms);

    /**
     * Gets the name of the creature.
     *
     * @return the name of the creature
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the creature.
     *
     * @param name the name of the creature
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current room where the creature is located.
     *
     * @return the current room of the creature
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
}
