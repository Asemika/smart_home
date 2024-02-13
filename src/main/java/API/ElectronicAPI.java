package API;

import entity.device.Light;
import entity.device.Microwave;
import entity.device.Oven;

public interface ElectronicAPI {
    FridgeAPI setFridgeAPI(FridgeAPI fridgeApi);
    TvAPI setTvAPI(TvAPI tvApi);
    BicycleAPI setBicycleAPI(BicycleAPI bicycleAPI);
    DeviceAPI setDeviceAPI(DeviceAPI deviceAPI);
    CarAPI setCarAPI(CarAPI carAPI);
    MicrowaveAPI setMicrowaveAPI(Microwave microwaveAPI);
    WindowAPI setWindowAPI(WindowAPI windowAPI);
    SmartSpeakerAPI setSmartSpeakerAPI(SmartSpeakerAPI smartSpeakerApi);
    OvenAPI setOvenApi(Oven ovenAPI);
    AirConditionAPI setAirConditionAPI(AirConditionAPI airConditionApi);
    LightAPI setLightSystemAPI(Light lightAPI);
    WashingMachineAPI setWashingMachineAPI(WashingMachineAPI washingMachineApi);
}

