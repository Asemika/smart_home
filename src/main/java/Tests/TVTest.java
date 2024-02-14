package Tests;


import API.ElectricityAPI;
import API.ElectronicAPI;
import entity.device.TV;
import event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import systems.WaterLeakSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TVTest {
    private TV tv;

    @BeforeEach
    public void setUp() {
        tv = new TV();
    }

    @Test
    public void testChangeChannelForward() {
        tv.getChannels().add("Channel 1");
        tv.getChannels().add("Channel 2");
        tv.setIndexOfCurrentChannel(0);

        tv.changeChannelForward();

        assertEquals(1, tv.getIndexOfCurrentChannel());
    }

    @Test
    public void testChangeChannelBackward() {
        tv.getChannels().add("Channel 1");
        tv.getChannels().add("Channel 2");
        tv.setIndexOfCurrentChannel(1);

        tv.changeChannelBackward();

        assertEquals(0, tv.getIndexOfCurrentChannel());
    }

}

