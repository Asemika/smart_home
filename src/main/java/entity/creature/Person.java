package entity.creature;

import API.BicycleAPI;
import API.CarAPI;
import entity.device.remote.AirConditionRemote;
import entity.device.remote.SmartSpeakerRemote;
import entity.device.remote.TVRemote;
import house.Room;
import house.Storey;

import java.util.List;

public class Person extends Creature {
    private CarAPI carAPI;
    private BicycleAPI bicycleAPI;
    private SmartSpeakerRemote smartSpeakerRemote;
    private AirConditionRemote airCondRemote;
    private TVRemote tvRemote;
    private String name;
    private int age;

    public Person(String name, Storey storey, Room initialRoom,
                  CarAPI carAPI, BicycleAPI bicycleAPI, SmartSpeakerRemote smartSpeakerRemote,
                  AirConditionRemote airCondRemote, TVRemote tvRemote) {
        super(name, initialRoom);
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
