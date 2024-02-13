package event;

import entity.device.AirCondition;
import entity.device.Device;
import house.Floor;
import house.House;
import house.Room;

public class SeasonalChangesEvent extends Event {
    private String season;

    public SeasonalChangesEvent(String season) {
        super("Seasonal changes event: It's now " + season + "!");
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void reactToSeason(House house) {
        System.out.println("Adjusting to seasonal changes.");

        adjustTemperature(house);

        adjustEnergyConsumption(house);
    }

    private void adjustTemperature(House house) {
        // TODO: Implement logic to adjust temperature based on the season
    }

    private void adjustEnergyConsumption(House house) {
        switch (season.toLowerCase()) {
            case "summer":
                increaseAirConditionerUsage(house);
                break;
//            case "winter":
//                increaseHeatingUsage(house);
//                break;
            default:
                break;
        }
    }

//    private void increaseHeatingUsage(House house) {
//        // Iterate through the floors and adjust heating usage
//        for (Floor floor : house.getFloors()) {
//            for (Room room : floor.getRooms()) {
//                for (Device device : room.getDevices()) {
//                    if (device instanceof HeatingSystem) {
//                        HeatingSystem heatingSystem = (HeatingSystem) device;
//                        // Check if the heating system is turned on and it's winter
//                        if (heatingSystem.isTurnedOn() && season.equalsIgnoreCase("winter")) {
//                            // Increase the temperature setting
//                            heatingSystem.setTemperature(heatingSystem.getTemperature() + 3);
//                            System.out.println("Increased heating usage in " + room.getName() +
//                                    " due to winter conditions.");
//                        }
//                    }
//                }
//            }
//        }
//    }


    private void increaseAirConditionerUsage(House house) {
        // Iterate through the floors and adjust air conditioner usage
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Device device : room.getDevices()) {
                    if (device instanceof AirCondition) {
                        AirCondition airCondition = (AirCondition) device;
                        if (airCondition.isTurnedOn()) {
                            airCondition.setTemperature(airCondition.getTemperature() + 2);
                            System.out.println("Increased air conditioner usage in " + room.getRoomName());
                        }
                    }
                }
            }
        }
    }

}
