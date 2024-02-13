package simulation;

import API.*;
import entity.creature.Person;
import entity.creature.Pet;
import entity.device.*;
import entity.device.remote.AirConditionRemote;
import entity.device.remote.SmartSpeakerRemote;
import entity.device.remote.TVRemote;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.WaterLeakSensor;
import house.House;
import house.Room;
import house.Window;
import systems.FireSystem;
import systems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Configuration2 {

    private static Configuration2 INSTANCE;
    private final String[] rooms = {"kitchen", "livingRoom", "bathRoom", "entertainmentRoom", "bedRoom1", "bedRoom2"};
    private final String[] peopleNames = {"Andrew", "Ales", "Jiri", "Katerina", "Tomas", "Lana"};
    private final List<Person> people = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private final List<WaterLeakSensor> devicesWithConsumption = new ArrayList<WaterLeakSensor>();
    private final List<WaterLeakSensor> sensors = new ArrayList<WaterLeakSensor>();
    private int initialFoodPercentage;


    public synchronized static Configuration2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration2();
        }
        return INSTANCE;
    }

    /**
     * factory method returning constructed working instance of house.
     *
     * @return House
     */
    public House initHouse() {
        House house = new House();

        Storey storey = new Storey();
        house.addStorey(storey);

        Room kitchen = new Room(rooms[0]);
        Room livingRoom = new Room(rooms[1]);
        Room bathRoom = new Room(rooms[2]);
        Room entertainmentRoom = new Room(rooms[3]);
        Room bedRoom = new Room(rooms[4]);
        Room bedRoom2 = new Room(rooms[5]);
        house.addRoom(kitchen)
                .addRoom(livingRoom)
                .addRoom(bathRoom)
                .addRoom(entertainmentRoom)
                .addRoom(bedRoom)
                .addRoom(bedRoom2);


        addOneWindowToEveryRoom(kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom, bedRoom2);

        List<Blinds> allBlinds = getBlindsFromRooms((List<Room>) storey);

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
        Oven owen = new Oven();
        WashingMachine washingMachine = new WashingMachine();
        Microwave microwave = new Microwave();
        LightSystem lightSystem = new LightSystem();

        addDevicesWithConsumption(devicesWithConsumption, fridge, tv, airCondition, airCondition2, smartSpeaker,
                owen, washingMachine, microwave, lightSystem);

        ElectronicAPI electronicApi = new ElectronicAPI()
                .setFridgeState(new FridgeState(fridge))
//                .setTvApi(new TvAPI(tv))
//                .setBlindsApi(new BlindsAPI(allBlinds))
                .setMicrowaveMode(new MicrowaveMode(microwave))
                .setSmartSpeakerApi(new SmartSpeakerAPI(smartSpeaker))
                .setOwenApi(new OvenMode(owen))
//                .setAirConditionApi(new AirConditionAPI(airConditions))
                .setLightSystemApi(new LightSystemState(lightSystem))
                .setWashingMachineApi(new WashingMachineAPI(washingMachine));

        SmartSpeakerRemote speakerRemote = new SmartSpeakerRemote(smartSpeaker);
        AirConditionRemote airCondRemote = new AirConditionRemote(airCondition);
        TVRemote tvRemote = new TVRemote(tv);

        init_people(people, peopleNames, storey, livingRoom, carAPI, new BicycleAPI(new Bicycle(true, true)), speakerRemote, airCondRemote, tvRemote);

        init_pets(pets, livingRoom);

        fillRoomWithDevices(kitchen, owen, fridge, microwave);
        fillRoomWithDevices(livingRoom, tv);
        fillRoomWithDevices(bathRoom, washingMachine);
        fillRoomWithDevices(entertainmentRoom, smartSpeaker);
        fillRoomWithDevices(bedRoom, airCondition);
        fillRoomWithDevices(bedRoom2, airCondition2);

        setUpFireSensors(house.getFireSystem(), devicesWithConsumption, sensors, kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom);

        setUpWaterSensors(house.getWaterLeakSystem(), (WaterLeakSystem) devicesWithConsumption, sensors, (List<Device>) kitchen, bathRoom);

        setUpFireSensors(house.getBackupGenerator(), devicesWithConsumption, sensors, kitchen, bathRoom, livingRoom, entertainmentRoom, bedRoom);

        setUpStrongWindSensor(allBlinds, livingRoom, devicesWithConsumption, sensors);

        attachPeopleToBreakableDevices(people, fridge, tv, airCondition, airCondition2, owen, microwave, washingMachine, smartSpeaker);

        for (WaterLeakSensor d : devicesWithConsumption) {
            sensors.add(d);
            d.turnOn();
        }
        return house;
    }

    private void setUpWaterSensors(WaterLeakSystem waterLeakSystem, WaterLeakSystem devicesWithConsumption, List<WaterLeakSensor> sensors, List<Device> kitchen, Room bathRoom) {

    }

    private void setUpFireSensors(FireSystem backupGenerator, List<WaterLeakSensor> devicesWithConsumption, List<WaterLeakSensor> sensors, Room kitchen, Room bathRoom, Room livingRoom, Room entertainmentRoom, Room bedRoom) {

    }


    public List<Person> getPeople() {
        return people;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public List<WaterLeakSensor> getDevicesWithConsumption() {
        return devicesWithConsumption;
    }

    public List<WaterLeakSensor> getSensors() {
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
     * @param rooms
     * @return all blind from all room on the storey.
     */
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


    /**
     * method to fill several devices to the list.
     *
     * @param devicesWithConsumption
     * @param devices
     */
    private void addDevicesWithConsumption(List<WaterLeakSensor> devicesWithConsumption, Device... devices) {
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
        pets.add(cat);
        pets.add(dog);
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
    private void setUpFireSensors(FireSystem fireSystem, List<FireSensor> devicesWithConsumption, List<FireSensor> sensors, Room... rooms) {
        for (Room room : rooms) {
            FireSensor fireSensor = new FireSensor() {
                @Override
                public void notifySystem() {

                }
            };
            room.addSensor(fireSensor);
            fireSensor.attach(fireSystem);
            devicesWithConsumption.add(fireSensor);
            sensors.add(fireSensor);
        }
    }

    /**
     * adds waterLeakSensor to the room, attaches it to the central waterLeakSystem of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param waterLeakSystem
     * @param leakSystem
     * @param withConsumption
     * @param devicesWithConsumption
     * @param rooms
     */
    private void setUpWaterSensors(WaterLeakSystem waterLeakSystem, WaterLeakSystem leakSystem, List<Device> withConsumption, List<WaterLeakSensor> devicesWithConsumption, Room... rooms) {
        for (Room room : rooms) {
            WaterLeakSensor waterLeakSensor = new WaterLeakSensor();
            room.addSensor(waterLeakSensor);
            waterLeakSensor.attach(waterLeakSystem);
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
            powerOutageSensor.attach(backupGenerator);
            devicesWithConsumption.add(powerOutageSensor);
            sensors.add(powerOutageSensor);
        }
    }


    /**
     * method for creating people.
     *
     * @param people
     * @param peopleNames
     * @param storey
     * @param livingRoom
     * @param carAPI
     * @param bicycleAPI
     * @param speakerRemote
     * @param airCondRemote
     * @param tvRemote
     */
    private void init_people(List<Person> people, String[] peopleNames, Storey storey, Room livingRoom, CarAPI carAPI, BicycleAPI bicycleAPI, SmartSpeakerRemote speakerRemote, AirConditionRemote airCondRemote, TVRemote tvRemote) {
        for (int i = 0; i < peopleNames.length; i++) {
            people.add(new Person(peopleNames[i], storey, livingRoom, carAPI, bicycleAPI, speakerRemote, airCondRemote, tvRemote));
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
        fridge.setFoodPercentage(initialFoodPercentage);

        // Simulate opening the fridge
        fridge.open();

        // Simulate doing other activities or checking the food percentage

        // Simulate closing the fridge
        fridge.close();

        // Order food if the percentage is below a certain threshold
        int thresholdPercentage = 30;
        fridge.orderFoodIfNeeded(thresholdPercentage);

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