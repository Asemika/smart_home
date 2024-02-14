package API;

import entity.device.Blinds;
import entity.device.Documentation;
import house.Room;
import house.Window;
import java.util.List;

/**
 * API for controlling blinds in rooms.
 */
public class BlindsAPI implements FixAPI {
    private List<Blinds> blinds;

    /**
     * Constructor for BlindsAPI class.
     *
     * @param blinds List of Blinds objects representing blinds in rooms
     */
    public BlindsAPI(List<Blinds> blinds) {
        this.blinds = blinds;
    }

    /**
     * Raises all blinds in the specified room.
     *
     * @param room the room in which to raise the blinds
     */
    public void turnOn(Room room) {
        if (room != null && room.getWindows() != null) {
            for (Window window : room.getWindows()) {
                if (window.getBlinds() != null) {
                    window.getBlinds().turnOn();
                }
            }
        }
    }

    /**
     * Lowers all blinds in the specified room.
     *
     * @param room the room in which to lower the blinds
     */
    public void turnOff(Room room) {
        if (room != null && room.getWindows() != null) {
            for (Window window : room.getWindows()) {
                if (window.getBlinds() != null) {
                    window.getBlinds().turnOff();
                }
            }
        }
    }

    /**
     * Fixes malfunctioning blinds.
     *
     * @param documentation the documentation for fixing the blinds
     */
    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing Blinds");
        for (Blinds b : blinds) {
            b.fixDevice();
        }
    }
}
