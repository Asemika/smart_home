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
package objects;

import API.BicycleAPI;
import API.CarAPI;
import API.ElectronicAPI;
import API.PersonActivityAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Observer {
    private final String name;
    private final Floor currentFloor;
    private Room currentRoom;
    private final ElectronicAPI electronicAPI;
//    private final List<Food> foodBag = new ArrayList<>();
    private final CarAPI carAPI;
    private final BicycleAPI bicycleAPI;
//    private final SmartSpeakerRemote smartSpeakerRemote;
//    private final AirCondRemote airCondRemote;
//    private final TvRemote tvRemote;
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

    public void getFoodFromFridge() {
        personActivityAPI.setFridgeCounter(personActivityAPI.getFridgeCounter() + 1);
        Food f = electronicAPI.getResult().getFridgeApi().getFood();
        if (f == null) {
            System.out.println("Fridge is empty or there is no requested food");
        } else {
            foodBag.add(f);
            electronicAPI.getResult().getFridgeApi().removeFoodByPerson(f);
        }
    }

//    public List<Food> getFoodBag() {
//        return foodBag;
//    }

    private boolean addFoodToFridge(Food food) {
        personActivityAPI.setFridgeCounter(personActivityAPI.getFridgeCounter() + 1);

        boolean successfullyAdded = electronicAPI.getResult().getFridgeApi().addFood(food);
        if (successfullyAdded) {
            foodBag.remove(food);
            return true;
        } else return false;
    }

    public boolean addAllFoodToFridge() {
        personActivityAPI.setFridgeCounter(personActivityAPI.getFridgeCounter() + 1);

        for (int i = 0; i < foodBag.size(); i++) {
            if (this.addFoodToFridge(foodBag.get(i)) == false) return false;
            i--;
        }
        return true;
    }

    public void watchTV() {
        personActivityAPI.setTvCounter(personActivityAPI.getTvCounter() + 1);
        electronicAPI.getResult().getTvApi().turnOn();
        electronicAPI.getResult().getTvApi().watchTV();
        tvRemote.changeChannel();
        electronicAPI.getResult().getTvApi().changeChannelForward();
        electronicAPI.getResult().getTvApi().watchTV();
        electronicAPI.getResult().getTvApi().turnOff();
    }

    public void bakeFoodInOwen(int time, List<Food> ingredients) {
        personActivityAPI.setOvenCounter(personActivityAPI.getOvenCounter() + 1);
        electronicAPI.getResult().getOvenApi().turnOn();
        electronicAPI.getResult().getOvenApi().bake(time, ingredients);
        electronicAPI.getResult().getOvenApi().turnOff();
    }

    public void heatFoodInMicrowave(Food food) {
        personActivityAPI.setMicrowaveCounter(personActivityAPI.getMicrowaveCounter() + 1);
        electronicAPI.getResult().getMicrowaveApi().turnOn();
        electronicAPI.getResult().getMicrowaveApi().heatFood(food);
        electronicAPI.getResult().getMicrowaveApi().turnOff();
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
        airCondRemote.turnOnRemotely();
        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
        electronicAPI.getResult().getAirConditionAPI().increaseTemp(1, currentRoom);
        airCondRemote.increaseTemp(changeOn, currentRoom);
    }

    public void decreaseTemp(int changeOn) {
        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
        airCondRemote.turnOnRemotely();
        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
        electronicAPI.getResult().getAirConditionAPI().decreaseTemp(1, currentRoom);
        airCondRemote.decreaseTemp(changeOn, currentRoom);
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

    public void listenToMusicWithRemote() {
        personActivityAPI.setSmartSpeakerCounter(personActivityAPI.getSmartSpeakerCounter() + 1);
        smartSpeakerRemote.turnOnRemotely();
        smartSpeakerRemote.playMusic();
        smartSpeakerRemote.turnOffRemotely();
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

    /**
     * chooses randomly one of the methods of person to use some device or to do sport.
     */
    public void doRandomActivity() {
        int numOfActivities = 18;
        Random rand = new Random();
        int randNum = rand.nextInt(numOfActivities);
        switch (randNum) {
            case 0 -> {
                getFoodFromFridge();
            }
            case 1 -> {
                if (!foodBag.isEmpty()) {
                    addFoodToFridge(foodBag.get(0));
                }
            }
            case 2 -> {
                watchTV();
            }
            case 3 -> {
                bakeFoodInOwen(30, getFoodBag());
            }
            case 4 -> {
                getFoodFromFridge();
                if (!foodBag.isEmpty()) heatFoodInMicrowave(getFoodBag().get(0));
            }
            case 5 -> {
                washClothes();
            }
            case 6 -> {
                blindsDown();
            }
            case 7 -> {
                blindsUp();
            }
            case 8 -> {
                increaseTemp(5);
            }
            case 9 -> {
                decreaseTemp(5);
            }
            case 10 -> {
                turnOnLightSystem();
            }
            case 11 -> {
                turnOffLightSystem();
            }
            case 12 -> {
                openWindows(currentRoom);
            }
            case 13 -> {
                closeWindows(currentRoom);
            }
            case 14 -> {
                listenToMusic();
            }
            case 15 -> {
                driveCar();
            }
            case 16 -> {
                listenToMusicWithRemote();
            }
            case 17 -> {
                useSkis();
            }
        }

    }

    public void changeRoom(List<Room> rooms) {
        Random random = new Random();
        int randRoomIndex = random.nextInt(rooms.size());
        currentRoom = rooms.get(randRoomIndex);
    }

    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType() == EventType.EMPTY_FRIDGE) {
            if (foodBag.size() == 0) { // we are going to the shop
                Food milk = new Food("vine");
                Food pizza = new Food("chocolate");
                Food salmon = new Food("salmon");
                Food cheese = new Food("ikra");
                Food water = new Food("water");
                Food meat = new Food("meat");
                Food apple = new Food("apple");
                foodBag.add(milk);
                foodBag.add(pizza);
                foodBag.add(salmon);
                foodBag.add(cheese);
                foodBag.add(water);
                foodBag.add(meat);
                foodBag.add(apple);
            }
            addAllFoodToFridge();
        } else if (event.getEventType() == EventType.BROKEN_DEVICE) {
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
//
//public class Person implements Observer {
//    private final String name;
//    private final Floor currentFloor;
//    private Room currentRoom;
//    private final ElectronicAPI electronicAPI;
//    private final CarAPI carAPI;
//    private final BicycleAPI bicycleAPI;
//    private final Activity personActivityAPI = new Activity();
//    private final Skis skis = new Skis();
//
//    public Person(String name, Floor currentFloor, Room currentRoom,
//                  CarAPI carAPI, BicycleAPI bicycleAPI, ElectronicAPI electronicAPI) {
//        this.name = name;
//        this.currentFloor = currentFloor;
//        this.currentRoom = currentRoom;
//        this.carAPI = carAPI;
//        this.bicycleAPI = bicycleAPI;
//        this.electronicAPI = electronicAPI;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Activity getPersonActivityAPI() {
//        return personActivityAPI;
//    }
//
//    public void watchTV() {
//        personActivityAPI.setTvCounter(personActivityAPI.getTvCounter() + 1);
//        electronicAPI.getResult().getTvApi().turnOn();
//        electronicAPI.getResult().getTvApi().watchTV();
//        electronicAPI.getResult().getTvApi().changeChannelForward();
//        electronicAPI.getResult().getTvApi().watchTV();
//        electronicAPI.getResult().getTvApi().turnOff();
//    }
//
//    /**
//     * simulating using skis.
//     */
//    public void useSkis() {
//        personActivityAPI.setSkiCounter(personActivityAPI.getSkiCounter() + 1);
//        skis.useSkis();
//    }
//    public void washClothes() {
//        personActivityAPI.setWashingMachineCounter(personActivityAPI.getWashingMachineCounter() + 1);
//
//        electronicAPI.getResult().getWashingMachineApi().turnOn();
//        electronicAPI.getResult().getWashingMachineApi().washClothes();
//        electronicAPI.getResult().getWashingMachineApi().turnOff();
//    }
//
//    public void blindsUp() {
//        personActivityAPI.setBlindsCounter(personActivityAPI.getBlindsCounter() + 1);
//        electronicAPI.getResult().getBlindsAPI().turnOff(currentRoom);
//    }
//
//    public void blindsDown() {
//        personActivityAPI.setBlindsCounter(personActivityAPI.getBlindsCounter() + 1);
//        electronicAPI.getResult().getBlindsAPI().turnOn(currentRoom);
//    }
//
//    public void increaseTemp(int changeOn) {
//        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
//        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
//        electronicAPI.getResult().getAirConditionAPI().increaseTemp(1, currentRoom);
//    }
//
//    public void decreaseTemp(int changeOn) {
//        personActivityAPI.setAirConditionCounter(personActivityAPI.getAirConditionCounter() + 1);
//        electronicAPI.getResult().getAirConditionAPI().turnOn(currentRoom);
//        electronicAPI.getResult().getAirConditionAPI().decreaseTemp(1, currentRoom);
//    }
//
//    /**
//     * simulating using car.
//     */
//    public void driveCar() {
//        personActivityAPI.setCarCounter(personActivityAPI.getCarCounter() + 1);
//        carAPI.driveCar();
//    }
//
//    /**
//     * just simulating of doing sport using bicycle.
//     */
//    public void rideBicycle() {
//        personActivityAPI.setBicycleCounter(personActivityAPI.getBicycleCounter() + 1);
//        bicycleAPI.rideBicycle();
//    }
//
//    public void turnOnLightSystem() {
//        personActivityAPI.setLightSystemCounter(personActivityAPI.getLightSystemCounter() + 1);
//        electronicAPI.getResult().getLightApi().turnOn(currentRoom);
//    }
//
//    public void turnOffLightSystem() {
//        personActivityAPI.setLightSystemCounter(personActivityAPI.getLightSystemCounter() + 1);
//        electronicAPI.getResult().getLightApi().turnOff(currentRoom);
//    }
//
//
//    public void listenToMusicWithRemote() {
//        personActivityAPI.setSmartSpeakerCounter(personActivityAPI.getSmartSpeakerCounter() + 1);
//    }
//
//    public void openWindows(Room room) {
//        personActivityAPI.setWindowsCounter(personActivityAPI.getWindowsCounter() + 1);
//        for (Window window : room.getWindows()) {
//            window.open();
//        }
//    }
//
//    public void closeWindows(Room room) {
//        personActivityAPI.setWindowsCounter(personActivityAPI.getWindowsCounter() + 1);
//        for (Window window : room.getWindows()) {
//            window.close();
//        }
//    }
//
//    /**
//     * chooses randomly one of the methods of person to use some device or to do sport.
//     */
//    public void doRandomActivity() {
//        int numOfActivities = 12; // Уменьшаем количество действий, чтобы учитывать только действия без еды
//        Random rand = new Random();
//        int randNum = rand.nextInt(numOfActivities);
//        switch (randNum) {
//            case 0:
//                watchTV();
//                break;
//            case 1:
//                washClothes();
//                break;
//            case 2:
//                blindsDown();
//                break;
//            case 3:
//                blindsUp();
//                break;
//            case 4:
//                increaseTemp(5);
//                break;
//            case 5:
//                decreaseTemp(5);
//                break;
//            case 6:
//                turnOnLightSystem();
//                break;
//            case 7:
//                turnOffLightSystem();
//                break;
//            case 8:
//                openWindows(currentRoom);
//                break;
//            case 9:
//                closeWindows(currentRoom);
//                break;
//            case 10:
//                listenToMusicWithRemote();
//                break;
//            default:
//                System.out.println("No activity selected.");
//        }
//    }
//
//
//    public void changeRoom(List<Room> rooms) {
//        Random random = new Random();
//        int randRoomIndex = random.nextInt(rooms.size());
//        currentRoom = rooms.get(randRoomIndex);
//    }
//
//    @Override
//    public void update(Event event, WaterLeakSensor sensor) {
//        if (event.getEventType().equals("BROKEN_DEVICE")) {
//            if (sensor instanceof Fridge) {
//                Documentation documentation = electronicAPI.getResult().getFridgeApi().getDocumentation();
//                electronicAPI.getResult().getFridgeApi().fixDevice(documentation);
//            } else if (sensor instanceof Microwave) {
//                Documentation documentation = electronicAPI.getResult().getMicrowaveApi().getDocumentation();
//                electronicAPI.getResult().getMicrowaveApi().fixDevice(documentation);
//            } else if (sensor instanceof SmartSpeaker) {
//                Documentation documentation = electronicAPI.getResult().getSmartSpeakerApi().getDocumentation();
//                electronicAPI.getResult().getSmartSpeakerApi().fixDevice(documentation);
//            } else if (sensor instanceof TV) {
//                Documentation documentation = electronicAPI.getResult().getTvApi().getDocumentation();
//                electronicAPI.getResult().getTvApi().fixDevice(documentation);
//            } else if (sensor instanceof WashingMachine) {
//                Documentation documentation = electronicAPI.getResult().getWashingMachineApi().getDocumentation();
//                electronicAPI.getResult().getWashingMachineApi().fixDevice(documentation);
//            } else if (sensor instanceof Oven) {
//                Documentation documentation = electronicAPI.getResult().getOvenApi().getDocumentation();
//                electronicAPI.getResult().getOvenApi().fixDevice(documentation);
//            } else if (sensor instanceof AirCondition) {
//                Documentation documentation = electronicAPI.getResult().getAirConditionAPI().getDocumentation();
//                electronicAPI.getResult().getAirConditionAPI().fixDevice(documentation);
//            }
//        }
//    }
//
//    @Override
//    public void update(Event event, Fridge fridge) {
//
//    }
//
//    @Override
//    public void attach(Observer observer) {
//
//    }
//
//    @Override
//    public void detach(Observer observer) {
//
//    }
//
//    @Override
//    public void notifyAllObservers(Event event) {
//
//    }
//
//    @Override
//    public void update(Event event, FireSensor fireSensor) {
//
//    }
//
//    @Override
//    public void update(Event event, PowerOutageSensor powerOutageSensor) {
//
//    }
//
//    @Override
//    public void update(Event event, StrongWindSensor strongWindSensor) {
//
//    }
//}