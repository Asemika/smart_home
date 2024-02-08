package entity.creature;

import house.Room;

import java.util.List;

public class Person extends Creature{
    private ElectronicAPI electronicAPI;
    private CarAPI carAPI;
    private BicycleAPI bicycleAPI;
    private SmartSpeakerRemote smartSpeakerRemote;
    private AirCondRemote airCondRemote;
    private TVRemote tvRemote;
    private String name;
    private int age;

    public Person(String name, Storey storey, Room initialRoom, ElectronicAPI electronicAPI,
                  CarAPI carAPI, BicycleAPI bicycleAPI, SmartSpeakerRemote smartSpeakerRemote,
                  AirCondRemote airCondRemote, TVRemote tvRemote) {
        super(name, initialRoom);
        this.electronicAPI = electronicAPI;
        this.carAPI = carAPI;
        this.bicycleAPI = bicycleAPI;
        this.smartSpeakerRemote = smartSpeakerRemote;
        this.airCondRemote = airCondRemote;
        this.tvRemote = tvRemote;
    }


    @Override
    public void doRandomActivity() {

    }

    @Override
    public void reactToEmergency() {
        System.out.println(getName() + " is reacting to an emergency.");
    }

    @Override
    public void changeRoom(List<Room> rooms) {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void rideBicycle(){

    }

    public void useSkis(){

    }
}
