package house;

import entity.device.Blinds;
import entity.device.AirCondition;
import entity.device.DeviceType;

public class Window {
    private boolean isOpen;
    private boolean hasShutter;
    private Blinds blinds;

    public Window(boolean hasShutter) {
        this.isOpen = false;
        this.hasShutter = hasShutter;
        this.blinds = new Blinds("Living Room Blinds", DeviceType.BLINDS, 5.0, 2.0, 1.0);
    }

    public Window() {
        this.isOpen = false;
        this.hasShutter = false;
        this.blinds = new Blinds("Living Room Blinds", DeviceType.BLINDS, 5.0, 2.0, 1.0);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
        System.out.println("Window is now open.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Window is now closed.");
    }

    public boolean hasShutter() {
        return hasShutter;
    }

    public Blinds getBlinds() {
        return blinds;
    }

    public void closeWindowsWhenAirConditionerOn() {
        if (AirCondition.isTurnedOn()) {
            close();
        }
    }

    // Метод для открытия и закрытия умных жалюзи
    public void openBlinds() {
        blinds.open();
    }

    public void closeBlinds() {
        blinds.close();
    }
    public void closeBlindsWhenNeeded() {
        if (AirCondition.isTurnedOn() || isNightTime() || isTooSunny()) {
            closeBlinds();
        }
    }

    private boolean isNightTime() {
        // Логика для определения ночного времени
        int currentHour = getCurrentHour(); // Предположим, что у вас есть метод для получения текущего часа
        return currentHour >= 20 || currentHour < 6;
    }

    private boolean isTooSunny() {
        // Логика для определения сильного солнечного света
    }

}
