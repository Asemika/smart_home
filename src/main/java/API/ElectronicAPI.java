package API;

import entity.device.*;

public interface ElectronicAPI {
    FridgeState setFridgeApi(FridgeState fridgeApi);
//    TvAPI setTvApi(TvAPI tvApi);
    BicycleAPI setBicycleAPI(BicycleAPI bicycleAPI);
    DeviceAPI setDeviceAPI(DeviceAPI deviceAPI);
    CarAPI setCarAPI(CarAPI carAPI);
    MicrowaveMode setMicrowaveApi(MicrowaveMode microwaveApi);
    WindowAPI setWindowAPI(WindowAPI windowAPI);
//    SmartSpeakerAPI setSmartSpeakerApi(SmartSpeakerAPI smartSpeakerApi);
    OvenModeStrategy setOwenApi(OvenModeStrategy owenApi);
//    AirConditionAPI setAirConditionApi(AirConditionAPI airConditionApi);
    LightSystemState setLightSystemApi(LightSystemState lightSystemApi);
//    WashingMachineAPI setWashingMachineApi(WashingMachineAPI washingMachineApi);
}

