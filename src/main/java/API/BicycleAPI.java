package API;

import entity.device.Bicycle;

public class BicycleAPI {
    Bicycle bicycle;

    public BicycleAPI(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    /**
     * person riding a bicycle.
     */
    public void rideBicycle() {
        bicycle.rideBicycle();
    }
}
