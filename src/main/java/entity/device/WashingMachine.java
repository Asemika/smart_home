package entity.device;

import API.WaterAPI;
import entity.sensor.FireSensor;
import entity.sensor.PowerOutageSensor;
import entity.sensor.StrongWindSensor;
import event.Event;
import systems.WaterLeakSystem;

public class WashingMachine extends Device {
    private final WaterAPI waterAPI = new WaterAPI();

    public void washClothes() {
        waterAPI.increaseCounter(40);
        getElectricityAPI().increaseCounter(getkWPerHour());

    }

    public WaterAPI getWaterAPI() {
        return waterAPI;
    }

    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void increaseTemp(int temp) {

    }

    @Override
    public void decreaseTemp(int temp) {

    }

    @Override
    public void update(Event event, AirCondition airCondition) {

    }


    @Override
    public void update(Event event, Fridge fridge) {

    }

    @Override
    public void update(Event event, FireSensor fireSensor) {

    }

    @Override
    public void update(Event event, PowerOutageSensor powerOutageSensor) {

    }

    @Override
    public void update(Event event, StrongWindSensor strongWindSensor) {

    }
}