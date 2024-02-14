package simulation;

import API.*;
import entity.creature.Person;
import entity.device.*;
import entity.sensor.*;
import house.*;
import entity.creature.Pet;
import systems.FireSystem;
import systems.LightSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Configuration {
    private static Configuration INSTANCE;
    private final String[] rooms = {"kitchen", "livingRoom", "bathRoom", "entertainmentRoom", "bedRoom1", "bedRoom2"};
    private final String[] peopleNames = {"John", "Alice", "Michael", "Roman", "David", "Sophie"};
    private final List<Person> people = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private final List<Device> devicesWithConsumption = new ArrayList<>();
    private final List<Device> sensors = new ArrayList<>();


    private Configuration() {
    }

    public synchronized static Configuration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration();
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
        floor.addRoom(kitchen)
                .addRoom(livingRoom)
                .addRoom(bathRoom)
                .addRoom(entertainmentRoom)
                .addRoom(bedRoom)
                .addRoom(bedRoom2);

        addOneWindowToEveryRoom(kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom, bedRoom2);

        List<Blinds> allBlinds = getBlindsFromRooms(floor.getRooms());

        Car car = new Car();
        CarAPI carAPI = new CarAPI(car);
        Fridge fridge = initFridge();

        TV tv = new TV();
        AirCondition airCondition = new AirCondition();
        AirCondition airCondition2 = new AirCondition();

        List<AirCondition> airConditions = new ArrayList<>();
        airConditions.add(airCondition);
        airConditions.add(airCondition2);

        SmartSpeaker smartSpeaker = new SmartSpeaker();
        Oven oven = new Oven();
        WashingMachine washingMachine = new WashingMachine();
        Microwave microwave = new Microwave();
        LightSystem lightSystem = new LightSystem();

        addDevicesWithConsumption(devicesWithConsumption, fridge, tv, airCondition, airCondition2, smartSpeaker,
                oven, washingMachine, microwave, lightSystem);

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

        initPets(pets, livingRoom);

        fillRoomWithDevices(kitchen, oven, fridge, microwave);
        fillRoomWithDevices(livingRoom, tv);
        fillRoomWithDevices(bathRoom, washingMachine);
        fillRoomWithDevices(entertainmentRoom, smartSpeaker);
        fillRoomWithDevices(bedRoom, airCondition);
        fillRoomWithDevices(bedRoom2, airCondition2);

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

    private void setUpWaterSensors(WaterLeakSystem waterLeakSystem, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            WaterLeakSensor waterLeakSensor = new WaterLeakSensor();
            room.addSensor(waterLeakSensor);
            waterLeakSensor.attach(waterLeakSystem);
            devicesWithConsumption.add(waterLeakSensor);
            sensors.add(waterLeakSensor);
        }
    }

    private void setUpFireSensors(FireSystem fireSystem, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            FireSensor fireSensor = new FireSensor();
            room.addSensor(fireSensor);
            fireSensor.attach(fireSystem);
            devicesWithConsumption.add(fireSensor);
            sensors.add(fireSensor);
        }
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

    private void addOneWindowToEveryRoom(Room... rooms) {
        for (Room room : rooms) {
            room.addWindow(new Window());
        }
    }

    private List<Blinds> getBlindsFromRooms(List<Room> rooms) {
        List<Blinds> blinds = new ArrayList<>();
        for (Room room : rooms) {
            List<Window> windows = room.getWindows();
            for (Window window : windows) {
                blinds.add(window.getBlinds());
            }
        }
        return blinds;
    }

    private void addDevicesWithConsumption(List<Device> devicesWithConsumption, Device... devices) {
        devicesWithConsumption.addAll(Arrays.asList(devices));
    }

    private void initPets(List<Pet> pets, Room room) {
        Pet cat = new Pet(room, "Cat");
        Pet dog = new Pet(room, "Dog");
        pets.add(cat);
        pets.add(dog);
    }

    private void fillRoomWithDevices(Room room, Device... devices) {
        for (Device device : devices) {
            room.addDevice(device);
        }
    }

    private void initPeople(List<Person> people, String[] peopleNames, Floor floor, Room livingRoom, CarAPI carAPI, BicycleAPI bicycleAPI,ElectronicAPI electronicAPI) {
        for (String personName : peopleNames) {
            people.add(new Person(personName, floor, livingRoom, carAPI, bicycleAPI,electronicAPI ));
        }
    }

    private Fridge initFridge() {
        Fridge fridge = new Fridge();
        fridge.turnOn();
        fridge.open();
        fridge.close();
        return fridge;
    }

    private void attachPeopleToBreakableDevices(List<Person> people, Device... devices) {
        for (Person person : people) {
            for (Device device : devices) {
                device.attach(person);
            }
        }
    }

    private void setUpStrongWindSensor(List<Blinds> allBlinds, Room livingRoom, List<Device> devicesWithConsumption, List<Device> sensors) {
        StrongWindSensor strongWindSensor = new StrongWindSensor();
        for (Blinds blinds : allBlinds) {
            strongWindSensor.attach(blinds);
        }
        livingRoom.addSensor(strongWindSensor);
        devicesWithConsumption.add(strongWindSensor);
        sensors.add(strongWindSensor);
    }
    private void setUpPowerOutageSensors(BackupGenerator backupGenerator, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            PowerOutageSensor powerOutageSensor = new PowerOutageSensor(backupGenerator);
            room.addSensor(powerOutageSensor);
            powerOutageSensor.attach(backupGenerator);
            devicesWithConsumption.add(powerOutageSensor);
            sensors.add(powerOutageSensor);
        }
    }
}
