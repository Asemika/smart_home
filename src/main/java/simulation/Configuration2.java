package simulation;

import API.*;
import API.MicrowaveAPI;
import entity.creature.Person;
import entity.creature.Pet;
import entity.device.*;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.WaterLeakSensor;
import house.Floor;
import house.House;
import house.Room;
import house.Window;
import systems.FireSystem;
import systems.LightSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.sensor.*;

public class Configuration2 {
    private static Configuration2 INSTANCE;
    private final String[] rooms = {"kitchen", "livingRoom", "bathRoom", "entertainmentRoom", "bedRoom1", "bedRoom2", "bedRoom3"};
    private final String[] peopleNames = {"George", "Ales", "Jerry", "Derek", "Arnold", "Kara"};
    private final List<Person> people = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private final List<Device> devicesWithConsumption = new ArrayList<>();
    private final List<Device> sensors = new ArrayList<>();

    private Configuration2() {
    }

    public synchronized static Configuration2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration2();
        }
        return INSTANCE;
    }

    public House initHouse() {
        House house = new House();

        Floor floor = new Floor();
        house.addFloor(floor);

        Room kitchen = new Room(rooms[0]);
        Room livingRoom = new Room(rooms[1]);
        Room bathRoom = new Room(rooms[2]);
        Room entertainmentRoom = new Room(rooms[3]);
        Room bedRoom = new Room(rooms[4]);
        Room bedRoom2 = new Room(rooms[5]);
        Room bedRoom3 = new Room(rooms[6]);
        floor.addRoom(kitchen)
                .addRoom(livingRoom)
                .addRoom(bathRoom)
                .addRoom(entertainmentRoom)
                .addRoom(bedRoom)
                .addRoom(bedRoom2)
                .addRoom(bedRoom3);

        addOneWindowToEveryRoom(kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom, bedRoom2);
        addOneWindowToEveryRoom(kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom, bedRoom2);

        List<Blinds> allBlinds = getBlindsFromRooms(floor);

        Car car = new Car();
        CarAPI carAPI = new CarAPI(car);
        Fridge fridge = initFridge();
        TV tv = new TV();

        AirCondition airCondition = new AirCondition();
        AirCondition airCondition2 = new AirCondition();
        AirCondition airCondition3 = new AirCondition();

        List<AirCondition> airConditions = new ArrayList<>();
        airConditions.add(airCondition);
        airConditions.add(airCondition2);
        airConditions.add(airCondition3);

        SmartSpeaker smartSpeaker = new SmartSpeaker();
        Oven oven = new Oven();
        WashingMachine washingMachine = new WashingMachine();
        Microwave microwave = new Microwave();
        LightSystem lightSystem = new LightSystem();

        addDevicesWithConsumption(devicesWithConsumption, fridge, tv, airCondition, airCondition2, smartSpeaker,
                oven, washingMachine, microwave, lightSystem, airCondition3);

        ElectronicAPI electronicAPI = new ElectronicAPI()
                .setFridgeApi(new FridgeAPI(fridge))
                .setTvApi(new TvAPI(tv))
                .setBlindsApi(new BlindsAPI(allBlinds))
                .setMicrowaveApi(new MicrowaveAPI(microwave))
                .setSmartSpeakerApi(new SmartSpeakerAPI(smartSpeaker))
                .setOvenApi(new OvenAPI(oven))
                .setAirConditionApi(new AirConditionAPI(airConditions))
                .setLightApi(new LightAPI(lightSystem))
                .setWashingMachineApi(new WashingMachineAPI(washingMachine));


        initPeople(people, peopleNames, floor, livingRoom, carAPI, new BicycleAPI(new Bicycle()), electronicAPI);
        init_pets(pets, livingRoom);
        fillRoomWithDevices(kitchen, oven, fridge, microwave);
        fillRoomWithDevices(livingRoom, tv);
        fillRoomWithDevices(bathRoom, washingMachine);
        fillRoomWithDevices(entertainmentRoom, smartSpeaker);
        fillRoomWithDevices(bedRoom, airCondition);
        fillRoomWithDevices(bedRoom2, airCondition2);
        fillRoomWithDevices(bedRoom3, airCondition3);

        setUpFireSensors(house.getFireSystem(), devicesWithConsumption, sensors, kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom);

        setUpWaterSensors(house.getWaterLeakSystem(), devicesWithConsumption, sensors, kitchen, bathRoom);

        setUpPowerOutageSensors(house.getBackupGenerator(), devicesWithConsumption, sensors, kitchen, bathRoom, livingRoom, entertainmentRoom, bedRoom);

        setUpStrongWindSensor(allBlinds, livingRoom, devicesWithConsumption, sensors);

        attachPeopleToBreakableDevices(people, fridge, tv, airCondition, airCondition2, oven, microwave, washingMachine, smartSpeaker);

        for (Device d : devicesWithConsumption) {
            sensors.add(d);
            d.turnOn();
        }

        return house;
    }

    private void setUpPowerOutageSensors(FireSystem backupGenerator, List<Device> devicesWithConsumption, List<Device> sensors, Room kitchen, Room bathRoom, Room livingRoom, Room entertainmentRoom, Room bedRoom) {
    }


    public List<Person> getPeople() {
        return people;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public List<Device> getDevicesWithConsumption() {
        return devicesWithConsumption;
    }

    public List<Device> getSensors() {
        return sensors;
    }


    /**
     * adds one window to every room from param.
     *
     * @param rooms
     */
    private void addOneWindowToEveryRoom(Room... rooms) {
        for (Room room : rooms) {
            room.addWindow(new Window());
        }
    }

    /**
     * @param floor
     * @return all blind from all room on the storey.
     */
    private List<Blinds> getBlindsFromRooms(Floor floor) {
        List<Blinds> blinds = new ArrayList<>();
        for (Room room : floor.getRooms()) {
            for (Window w : room.getWindows()) {
                blinds.add(w.getBlinds());
            }
        }
        return blinds;
    }

    /**
     * method to fill several devices to the list.
     *
     * @param devicesWithConsumption
     * @param devices
     */
    private void addDevicesWithConsumption(List<Device> devicesWithConsumption, Device... devices) {
        devicesWithConsumption.addAll(Arrays.asList(devices));
    }

    /**
     * method for pets configuring.
     *
     * @param pets
     * @param room
     */
    private void init_pets(List<Pet> pets, Room room) {
        Pet cat = new Pet(room, "Cat");
        Pet dog = new Pet(room, "Dog");
        Pet rat = new Pet(room, "Rat");
        pets.add(cat);
        pets.add(dog);
        pets.add(rat);
    }

    /**
     * adds multiple amount of devices into room.
     *
     * @param room
     * @param devices
     */
    private void fillRoomWithDevices(Room room, Device... devices) {
        for (Device device : devices) {
            room.addDevice(device);
        }
    }

    /**
     * adds fireSensor to the room, attaches it to the central fireSystem of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param fireSystem
     * @param devicesWithConsumption
     * @param sensors
     * @param rooms
     */
    private void setUpFireSensors(FireSystem fireSystem, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            FireSensor fireSensor = new FireSensor();
            room.addSensor(fireSensor);
            fireSensor.attach((Observer) fireSystem);
            devicesWithConsumption.add(fireSensor);
            sensors.add(fireSensor);
        }
    }
    /**
     * adds waterLeakSensor to the room, attaches it to the central waterLeakSystem of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param waterLeakSystem
     * @param devicesWithConsumption
     * @param sensors
     * @param rooms
     */
    private void setUpWaterSensors(WaterLeakSystem waterLeakSystem, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            WaterLeakSensor waterLeakSensor = new WaterLeakSensor();
            room.addSensor(waterLeakSensor);
            waterLeakSensor.attach((Observer) waterLeakSystem);
            devicesWithConsumption.add(waterLeakSensor);
            sensors.add(waterLeakSensor);
        }
    }

    /**
     * adds powerOutageSensor to the room, attaches it to the backUpGenerator of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param backupGenerator
     * @param devicesWithConsumption
     * @param sensors
     * @param rooms
     */
    private void setUpPowerOutageSensors(BackupGenerator backupGenerator, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            PowerOutageSensor powerOutageSensor = new PowerOutageSensor(backupGenerator);
            room.addSensor(powerOutageSensor);
            powerOutageSensor.attach((Observer) backupGenerator);
            devicesWithConsumption.add(powerOutageSensor);
            sensors.add(powerOutageSensor);
        }
    }

    /**
     * adds strongWindSensor to the room, attaches it to the blinds of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param allBlinds
     * @param livingRoom
     * @param devicesWithConsumption
     * @param sensors
     */
    private void setUpStrongWindSensor(List<Blinds> allBlinds, Room livingRoom, List<Device> devicesWithConsumption, List<Device> sensors) {
        StrongWindSensor strongWindSensor = new StrongWindSensor();
        for (Blinds b : allBlinds) {
            strongWindSensor.attach(b);
        }
        livingRoom.addSensor(strongWindSensor);
        devicesWithConsumption.add(strongWindSensor);
        sensors.add(strongWindSensor);
    }

    /**
     * method for creating people
     *
     * @param people
     * @param floor
     * @param livingRoom
     * @param electronicAPI
     * @param carAPI
     * @param bicycleAPI
     */
    private void initPeople(List<Person> people, String[] peopleNames, Floor floor, Room livingRoom, CarAPI carAPI, BicycleAPI bicycleAPI,ElectronicAPI electronicAPI) {
        for (String personName : peopleNames) {
            people.add(new Person(personName, floor, livingRoom, carAPI, bicycleAPI,electronicAPI ));
        }
    }


    /**
     * factory method for creating a fridge with some food.
     *
     * @return fridge instance
     */
    private Fridge initFridge() {
        Fridge fridge = new Fridge();
        fridge.turnOn();
        fridge.addFood();
        return fridge;
    }

    /**
     * @param people
     * @param devices
     */
    private void attachPeopleToBreakableDevices(List<Person> people, Device... devices) {
        for (Person person : people) {
            for (Device device : devices) {
                device.attach(person);
            }
        }
    }
}