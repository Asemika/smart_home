package entity.device;

import API.WaterAPI;
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


}