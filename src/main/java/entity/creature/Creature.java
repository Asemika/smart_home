package entity.creature;

import house.Room;

import java.util.List;

public abstract class Creature {
    private String name;
    private Room currentRoom;
    public Creature(String name, Room initialRoom) {
        this.name = name;
        this.currentRoom = initialRoom;
    }

    public abstract void doRandomActivity();
    public abstract void reactToEmergency();
    public abstract void changeRoom(List<Room> rooms);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
}
