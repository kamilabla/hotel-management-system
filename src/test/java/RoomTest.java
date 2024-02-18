import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void testGetRoomNumber() {
        Room room = new Room(7);

        assertEquals(7, room.getRoomNumber());
    }

    @Test
    void testSetAndGetGuestName() {
        Room room = new Room(7);

        room.setGuestName("Anna Kowalska");

        assertEquals("Anna Kowalska", room.getGuestName());
    }
}
