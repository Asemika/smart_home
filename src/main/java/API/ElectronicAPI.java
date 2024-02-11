package API;

import entity.device.*;

public interface ElectronicAPI {
    FridgeAPI setFridgeApi(FridgeAPI fridgeApi);
    TvAPI setTvApi(TvAPI tvApi);
    BlindsAPI setBlindsApi(BlindsAPI blindsApi);
    MicrowaveAPI setMicrowaveApi(MicrowaveAPI microwaveApi);
    SmartSpeakerAPI setSmartSpeakerApi(SmartSpeakerAPI smartSpeakerApi);
    OwenAPI setOwenApi(OwenAPI owenApi);
    AirConditionAPI setAirConditionApi(AirConditionAPI airConditionApi);
    LightSystemAPI setLightSystemApi(LightSystemAPI lightSystemApi);
    WashingMachineAPI setWashingMachineApi(WashingMachineAPI washingMachineApi);
}

