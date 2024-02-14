package entity.creature;

import API.BicycleAPI;
import API.CarAPI;
import API.ElectronicAPI;
import activities.Activity;
import entity.device.*;
import entity.sensor.*;
import event.Event;
import event.EventType;
import house.Floor;
import house.Room;
import house.Window;

import java.util.List;
import java.util.Random;

/**
 * Represents a person in the house who can perform various activities.
 */
public class Person implements Observer {
    private final String name;
    private final Floor currentFloor;
    private Room currentRoom;
    private final ElectronicAPI electronicAPI;
    private final CarAPI carAPI;
    private final BicycleAPI bicycleAPI;
    private final Activity personActivityAPI = new Activity();
    private final Skis skis = new Skis();

    /**
     * Constructs a person with the specified name, current floor, room, car API,
     * bicycle API, and electronic API.
     *
     * @param name           the name of the person
     * @param currentFloor   the current floor where the person is located
     * @param currentRoom    the current room where the person is located
     * @param carAPI         the car API for the person's car
     * @param bicycleAPI     the bicycle API for the person's bicycle
     * @param electronicAPI  the electronic API for the person's electronic devices
     */
    public Person(String name, Floor currentFloor, Room currentRoom,
                  CarAPI carAPI, BicycleAPI bicycleAPI, ElectronicAPI electronicAPI) {
        this.bicycleAPI = bicycleAPI;
        this.carAPI = carAPI;
        this.name = name;
        this.currentFloor = currentFloor;
        this.currentRoom = currentRoom;
        this.electronicAPI = electronicAPI;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the activity API associated with the person.
     *
     * @return the activity API associated with the person
     */
    public Activity getPersonActivityAPI() {
        return personActivityAPI;
    }

    /**
     * Simulates the action of watching TV.
     */
    public void watchTV() {
        personActivityAPI.setTvCounter(personActivityAPI.getTvCounter() + 1);
        electronicAPI.getResult().getTvApi().turnOn();
        electronicAPI.getResult().getTvApi().watchTV();
        electronicAPI.getResult().getTvApi().changeChannelForward();
        electronicAPI.getResult().getTvApi().watchTV();
        electronicAPI.getResult().getTvApi().turnOff();
    }

    /**
     * Simulates the action of using skis.
     */
    public void useSkis() {
        personActivityAPI.setSkiCounter(personActivityAPI.getSkiCounter() + 1);
        skis.useSkis();
    }

    /**
     * Simulates the action of washing clothes.
     */
    public void washClothes() {
        personActivityAPI.setWashingMachineCounter(personActivityAPI.getWashingMachineCounter() + 1);
        electronicAPI.getResult().getWashingMachineApi().turnOn();
        electronicAPI.getResult().getWashingMachineApi().washClothes();
        electronicAPI.getResult().getWashingMachineApi().turnOff();
    }

    /**
     * Simulates the action of raising blinds.
     */
    public void blindsUp() {
        personActivityAPI.setBlindsCounter(personActivityAPI.getBlindsCounter() + 1);
        electronicAPI.getResult().getBlindsAPI().turnOff(currentRoom);
    }

    /**
     * Simulates the action of lowering blinds.
     */
    public void blindsDown() {
        personActivityAPI.setBlindsCounter(personActivityAPI.getBlindsCounter() + 1);
        electronicAPI.getResult().getBlindsAPI().turnOn(currentRoom);
    }

    /**
     * Increases the temperature in the current room.
     *
     * @param changeOn the amount by which to increase the temperature
     */
    public void increaseTemp(int changeOn) {
        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
        electronicAPI.getResult().getAirConditionAPI().increaseTemp(1, currentRoom);
    }

    /**
     * Decreases the temperature in the current room.
     *
     * @param changeOn the amount by which to decrease the temperature
     */
    public void decreaseTemp(int changeOn) {
        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
        electronicAPI.getResult().getAirConditionAPI().decreaseTemp(1, currentRoom);
    }

    /**
     * Simulates the action of driving a car.
     */
    public void driveCar() {
        personActivityAPI.setCarCounter(personActivityAPI.getCarCounter() + 1);
        carAPI.driveCar();
    }

    /**
     * Simulates the action of riding a bicycle.
     */
    public void rideBicycle() {
        personActivityAPI.setBicycleCounter(personActivityAPI.getBicycleCounter() + 1);
        bicycleAPI.rideBicycle();
    }

    /**
     * Turns on the light system in the current room.
     */
    public void turnOnLightSystem() {
        personActivityAPI.setLightSystemCounter(personActivityAPI.getLightSystemCounter() + 1);
        electronicAPI.getResult().getLightApi().turnOn(currentRoom);
    }

    /**
     * Turns off the light system in the current room.
     */
    public void turnOffLightSystem() {
        personActivityAPI.setLightSystemCounter(personActivityAPI.getLightSystemCounter() + 1);
        electronicAPI.getResult().getLightApi().turnOff(currentRoom);
    }

    /**
     * Simulates the action of listening to music.
     */
    public void listenToMusic() {
        personActivityAPI.setSmartSpeakerCounter(personActivityAPI.getSmartSpeakerCounter() + 1);
        electronicAPI.getResult().getSmartSpeakerApi().turnOn();
        electronicAPI.getResult().getSmartSpeakerApi().playMusic();
        electronicAPI.getResult().getSmartSpeakerApi().changeMusicForward();
        electronicAPI.getResult().getSmartSpeakerApi().changeMusicForward();
        electronicAPI.getResult().getSmartSpeakerApi().turnOff();
    }

    /**
     * Opens the windows in the specified room.
     *
     * @param room the room where the windows are to be opened
     */
    public void openWindows(Room room) {
        personActivityAPI.setWindowsCounter(personActivityAPI.getWindowsCounter() + 1);
        for (Window window : room.getWindows()) {
            window.open();
        }
    }

    /**
     * Closes the windows in the specified room.
     *
     * @param room the room where the windows are to be closed
     */
    public void closeWindows(Room room) {
        personActivityAPI.setWindowsCounter(personActivityAPI.getWindowsCounter() + 1);
        for (Window window : room.getWindows()) {
            window.close();
        }
    }

    /**
     * Performs a random activity among the available options.
     */
    public void doRandomActivity() {
        int numOfActivities = 14;
        Random rand = new Random();
        int randNum = rand.nextInt(numOfActivities);
        switch (randNum) {
            case 0 -> watchTV();
            case 1 -> washClothes();
            case 2 -> blindsDown();
            case 3 -> blindsUp();
            case 4 -> increaseTemp(5);
            case 5 -> decreaseTemp(5);
            case 6 -> turnOnLightSystem();
            case 7 -> turnOffLightSystem();
            case 8 -> openWindows(currentRoom);
            case 9 -> closeWindows(currentRoom);
            case 10 -> listenToMusic();
            case 11 -> driveCar();
            case 12 -> useSkis();
        }
    }

    /**
     * Changes the current room of the person to a random room on the same floor.
     *
     * @param rooms the list of rooms on the same floor where the person can move
     */
    public void changeRoom(List<Room> rooms) {
        Random random = new Random();
        int randRoomIndex = random.nextInt(rooms.size());
        currentRoom = rooms.get(randRoomIndex);
    }

    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType().equals(EventType.BROKEN_DEVICE)) {
            if (sensor instanceof Fridge) {
                Documentation documentation = electronicAPI.getResult().getFridgeApi().getDocumentation();
                electronicAPI.getResult().getFridgeApi().fixDevice(documentation);
            } else if (sensor instanceof Microwave) {
                Documentation documentation = electronicAPI.getResult().getMicrowaveApi().getDocumentation();
                electronicAPI.getResult().getMicrowaveApi().fixDevice(documentation);
            } else if (sensor instanceof SmartSpeaker) {
                Documentation documentation = electronicAPI.getResult().getSmartSpeakerApi().getDocumentation();
                electronicAPI.getResult().getSmartSpeakerApi().fixDevice(documentation);
            } else if (sensor instanceof TV) {
                Documentation documentation = electronicAPI.getResult().getTvApi().getDocumentation();
                electronicAPI.getResult().getTvApi().fixDevice(documentation);
            } else if (sensor instanceof WashingMachine) {
                Documentation documentation = electronicAPI.getResult().getWashingMachineApi().getDocumentation();
                electronicAPI.getResult().getWashingMachineApi().fixDevice(documentation);
            } else if (sensor instanceof Oven) {
                Documentation documentation = electronicAPI.getResult().getOvenApi().getDocumentation();
                electronicAPI.getResult().getOvenApi().fixDevice(documentation);
            } else if (sensor instanceof AirCondition) {
                Documentation documentation = electronicAPI.getResult().getAirConditionAPI().getDocumentation();
                electronicAPI.getResult().getAirConditionAPI().fixDevice(documentation);
            }
        }
    }
}
