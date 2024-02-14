package API;


public class ElectronicAPI {
    private TvAPI tvApi;
    private OvenAPI ovenApi;
    private SmartSpeakerAPI smartSpeakerApi;
    private MicrowaveAPI microwaveApi;
    private LightAPI lightApi;
    private FridgeAPI fridgeApi;
    private WashingMachineAPI washingMachineApi;
    private AirConditionAPI airConditionAPI;
    private BlindsAPI blindsAPI;

    /**
     * container for all apies for person.
     */
    public ElectronicAPI() {
    }


    public ElectronicAPI getResult() {
        return this;
    }

    public BlindsAPI getBlindsAPI() {
        return blindsAPI;
    }

    public ElectronicAPI setBlindsApi(BlindsAPI blindsAPI) {
        this.blindsAPI = blindsAPI;
        return this;
    }

    public TvAPI getTvApi() {
        return tvApi;
    }

    public ElectronicAPI setTvApi(TvAPI tvApi) {
        this.tvApi = tvApi;
        return this;
    }

    public OvenAPI getOvenApi() {
        return ovenApi;
    }

    public ElectronicAPI setOvenApi(OvenAPI ovenApi) {
        this.ovenApi = ovenApi;
        return this;
    }

    public SmartSpeakerAPI getSmartSpeakerApi() {
        return smartSpeakerApi;
    }

    public ElectronicAPI setSmartSpeakerApi(SmartSpeakerAPI smartSpeakerApi) {
        this.smartSpeakerApi = smartSpeakerApi;
        return this;
    }

    public MicrowaveAPI getMicrowaveApi() {
        return microwaveApi;
    }

    public ElectronicAPI setMicrowaveApi(MicrowaveAPI microwaveApi) {
        this.microwaveApi = microwaveApi;
        return this;
    }

    public LightAPI getLightApi() {
        return lightApi;
    }

    public ElectronicAPI setLightApi(LightAPI lightApi) {
        this.lightApi = lightApi;
        return this;
    }

    public FridgeAPI getFridgeApi() {
        return fridgeApi;
    }

    public ElectronicAPI setFridgeApi(FridgeAPI fridgeApi) {
        this.fridgeApi = fridgeApi;
        return this;
    }

    public WashingMachineAPI getWashingMachineApi() {
        return washingMachineApi;
    }

    public ElectronicAPI setWashingMachineApi(WashingMachineAPI washingMachineApi) {
        this.washingMachineApi = washingMachineApi;
        return this;
    }

    public AirConditionAPI getAirConditionApi() {
        return airConditionAPI;
    }

    public ElectronicAPI setAirConditionApi(AirConditionAPI airConditionAPI) {
        this.airConditionAPI = airConditionAPI;
        return this;
    }

    public AirConditionAPI getAirConditionAPI() {
        return airConditionAPI;
    }
}