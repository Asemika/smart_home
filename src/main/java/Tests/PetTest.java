package Tests;
import entity.creature.Pet;
import house.Room;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetTest {

    @Test
    public void testGetType() {
        Room room = new Room("Living Room");
        Pet pet = new Pet("Tom", room, "Cat");
        assertEquals("Cat", pet.getType());
    }

    @Test
    public void testChangeRoom() {
        Room room1 = new Room("Living Room");
        Room room2 = new Room("Kitchen");
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        Pet pet = new Pet("Tom", room1, "Cat");
        Room initialRoom = pet.getCurrentRoom();

        pet.changeRoom(rooms);
        Room newRoom = pet.getCurrentRoom();

        assertNotNull(newRoom);
        assertTrue(rooms.contains(newRoom));
        assertTrue(newRoom != initialRoom);
    }
}