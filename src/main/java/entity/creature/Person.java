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

public class Person implements Observer {
    private final String name;
    private final Floor currentFloor;
    private Room currentRoom;
    private final ElectronicAPI electronicAPI;
    private final CarAPI carAPI;
    private final BicycleAPI bicycleAPI;
    private final Activity personActivityAPI = new Activity();
    private final Skis skis = new Skis();

    public Person(String name, Floor currentFloor, Room currentRoom,
                  CarAPI carAPI, BicycleAPI bicycleAPI, ElectronicAPI electronicAPI) {
        this.bicycleAPI = bicycleAPI;
        this.carAPI = carAPI;
        this.name = name;
        this.currentFloor = currentFloor;
        this.currentRoom = currentRoom;
        this.electronicAPI = electronicAPI;
    }

    public String getName() {
        return name;
    }

    public Activity getPersonActivityAPI() {
        return personActivityAPI;
    }


    public void watchTV() {
        personActivityAPI.setTvCounter(personActivityAPI.getTvCounter() + 1);
        electronicAPI.getResult().getTvApi().turnOn();
        electronicAPI.getResult().getTvApi().watchTV();
        electronicAPI.getResult().getTvApi().changeChannelForward();
        electronicAPI.getResult().getTvApi().watchTV();
        electronicAPI.getResult().getTvApi().turnOff();
    }

    /**
     * simulating using skis.
     */
    public void useSkis() {
        personActivityAPI.setSkiCounter(personActivityAPI.getSkiCounter() + 1);
        skis.useSkis();
    }

    public void washClothes() {
        personActivityAPI.setWashingMachineCounter(personActivityAPI.getWashingMachineCounter() + 1);

        electronicAPI.getResult().getWashingMachineApi().turnOn();
        electronicAPI.getResult().getWashingMachineApi().washClothes();
        electronicAPI.getResult().getWashingMachineApi().turnOff();
    }

    public void blindsUp() {
        personActivityAPI.setBlindsCounter(personActivityAPI.getBlindsCounter() + 1);
        electronicAPI.getResult().getBlindsAPI().turnOff(currentRoom);
    }

    public void blindsDown() {
        personActivityAPI.setBlindsCounter(personActivityAPI.getBlindsCounter() + 1);
        electronicAPI.getResult().getBlindsAPI().turnOn(currentRoom);
    }

    public void increaseTemp(int changeOn) {
        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
        electronicAPI.getResult().getAirConditionAPI().increaseTemp(1, currentRoom);
    }

    public void decreaseTemp(int changeOn) {
        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
        electronicAPI.getResult().getAirConditionAPI().decreaseTemp(1, currentRoom);
    }

    /**
     * simulating using car.
     */
    public void driveCar() {
        personActivityAPI.setCarCounter(personActivityAPI.getCarCounter() + 1);
        carAPI.driveCar();
    }

    /**
     * just simulating of doing sport using bicycle.
     */
    public void rideBicycle() {
        personActivityAPI.setBicycleCounter(personActivityAPI.getBicycleCounter() + 1);
        bicycleAPI.rideBicycle();
    }

    public void turnOnLightSystem() {
        personActivityAPI.setLightSystemCounter(personActivityAPI.getLightSystemCounter() + 1);
        electronicAPI.getResult().getLightApi().turnOn(currentRoom);
    }

    public void turnOffLightSystem() {
        personActivityAPI.setLightSystemCounter(personActivityAPI.getLightSystemCounter() + 1);
        electronicAPI.getResult().getLightApi().turnOff(currentRoom);
    }

    public void listenToMusic() {
        personActivityAPI.setSmartSpeakerCounter(personActivityAPI.getSmartSpeakerCounter() + 1);
        electronicAPI.getResult().getSmartSpeakerApi().turnOn();
        electronicAPI.getResult().getSmartSpeakerApi().playMusic();
        electronicAPI.getResult().getSmartSpeakerApi().changeMusicForward();
        electronicAPI.getResult().getSmartSpeakerApi().changeMusicForward();
        electronicAPI.getResult().getSmartSpeakerApi().turnOff();
    }


    public void openWindows(Room room) {
        personActivityAPI.setWindowsCounter(personActivityAPI.getWindowsCounter() + 1);
        for (Window window : room.getWindows()) {
            window.open();
        }
    }

    public void closeWindows(Room room) {
        personActivityAPI.setWindowsCounter(personActivityAPI.getWindowsCounter() + 1);
        for (Window window : room.getWindows()) {
            window.close();
        }
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
