package Tests;

import event.SmokeSignalEvent;
import org.junit.Test;
import static org.junit.Assert.*;

public class SmokeSignalEventTest {

    @Test
    public void testConstructor() {
        SmokeSignalEvent event = new SmokeSignalEvent();
        assertNotNull(event);
        assertFalse(event.isSignalDetected());
        assertEquals("Smoke signal event: Smoke signals detected!", event.getDescription());
    }

    @Test
    public void testAcknowledgeSignal() {
        SmokeSignalEvent event = new SmokeSignalEvent();
        assertFalse(event.isSignalDetected());

        event.acknowledgeSignal();
        assertTrue(event.isSignalDetected());
    }
}

