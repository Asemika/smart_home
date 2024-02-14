//package Tests;
//
//import entity.device.AirCondition;
//import event.SeasonalChangesEvent;
//import house.Floor;
//import house.House;
//import house.Room;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//class SeasonalChangesEventTest {
//    private SeasonalChangesEvent event;
//
//    @BeforeEach
//    void setUp() {
//        event = new SeasonalChangesEvent("summer");
//    }
//
//
//    @Test
//    void testReactToSeason() {
//        House house = mock(House.class);
//        Floor floor = mock(Floor.class);
//        Room room = mock(Room.class);
//        AirCondition airCondition = mock(AirCondition.class);
//
//        when(house.getFloors()).thenReturn(List.of(floor));
//        when(floor.getRooms()).thenReturn(List.of(room));
//        when(room.getDevices()).thenReturn(List.of(airCondition));
//        when(airCondition.isTurnedOn()).thenReturn(true);
//        when(airCondition.getTemperature()).thenReturn(20);
//
//        event.reactToSeason(house);
//
//        verify(airCondition, times(1)).setTemperature(22);
//    }
//}
