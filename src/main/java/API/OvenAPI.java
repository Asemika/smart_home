package API;
import entity.device.Documentation;
//import entity.device.Food;
import entity.device.Oven;
import States.TurnedOnState;

import java.util.List;
    public class OvenAPI implements FixAPI {
        Oven oven;

        public OvenAPI(Oven oven) {
            this.oven = oven;
        }

        public void turnOn() {
            oven.turnOn();
        }

        public void turnOff() {
            oven.turnOff();
        }

        @Override
        public void fixDevice(Documentation documentation) {
            System.out.println("Fixing own");
            oven.fixDevice();
        }

        public Documentation getDocumentation() {
            return oven.getDocumentation();

        }

        public void execute(Oven oven) {
        }
    }