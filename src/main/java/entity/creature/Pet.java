package entity.creature;

import house.Room;

import java.util.List;

public class Pet extends Creature {
    private String name;
    private PetType petType;

    public Pet(Room initialRoom, PetType petType) {
        super(petType.name(), initialRoom);
        this.petType = petType;
    }

    @Override
    public void doRandomActivity() {

    }

    @Override
    public void reactToEmergency() {
        System.out.println(petType + " is reacting to an emergency.");
    }
    @Override
    public void changeRoom(List<Room> rooms) {

    }

    public String getName() {
        return name;
    }

    public PetType getPetType() {
        return petType;
    }

}
