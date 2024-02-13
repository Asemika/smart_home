package API;
import entity.device.Documentation;
import entity.device.Food;
import entity.device.Oven;
import States.TurnedOnState;

import java.util.List;
    public class OvenAPI implements FuncWearOutAPI {
        Oven owen;

        public OvenAPI(Oven oven) {
            this.oven = oven;
        }

        public void turnOn() {
            oven.turnOn();
        }

        public void turnOff() {
            oven.turnOff();
        }

        /**
         * changes state of food on baked.
         *
         * @param time
         * @param food
         */
        public void bake(int time, List<Food> food) {
            if (oven.getActivityState() instanceof TurnedOnState) {
                oven.bake(time, food);
            } else System.out.println("device is not turned on");

        }

        @Override
        public void fixDevice(Documentation documentation) {
            System.out.println("Fixing own");
            owen.fixDevice();
        }

        public Documentation getDocumentation() {
            return oven.getDocumentation();

        }
    }