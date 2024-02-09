package entity.device.patterns;

import entity.device.interfaces.MicrowaveMode;

public class DefrostMode implements MicrowaveMode {
    @Override
    public void execute() {
        System.out.println("Microwave is now in defrost mode.");
        // Логика выполнения размораживания продуктов
    }
}
