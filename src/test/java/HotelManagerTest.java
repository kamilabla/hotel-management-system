import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
//import java.io.InputStream;


public class HotelManagerTest {
    @Test
    void testCheckInGuest() {
        InputStream originalSystemIn = System.in;

        String input = "101\nAnna Kowalska\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HotelManager hotelManager = new HotelManager();
        hotelManager.checkInGuest();

        Room room = hotelManager.myMap.get(101);

        assertNotNull(room);
        assertEquals("Anna Kowalska", room.getGuestName());
        System.setIn(originalSystemIn);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCheckInGuestNotFound() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            String input = "104\nAnna Kowalska";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            HotelManager hotelManager = new HotelManager();


            hotelManager.checkInGuest();

            String expectedOutput = "Room not found.";
            assertEquals(expectedOutput, outContent.toString().replaceAll("\r\n", "\n").trim());

        } finally {
            // Reset System.out to the original stream to avoid interference with other tests
            System.setOut(System.out);
        }

    }

    @Test
    void testCheckOutGuest() {
        InputStream originalSystemIn = System.in;
        String input = "101\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HotelManager hotelManager = new HotelManager();

        Room room = hotelManager.myMap.get(101);
        room.setGuestName("Anna Kowalska");
        hotelManager.checkOutGuest();
        Room checkedOutRoom = hotelManager.myMap.get(101);

        assertNotNull(checkedOutRoom);
        assertNull(checkedOutRoom.getGuestName());

        System.setIn(originalSystemIn);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));     // robione po to, aby móc przetestować funkcję printującą
        HotelManager hotelManager = new HotelManager();
        Room room = hotelManager.myMap.get(301);
        room.setGuestName("Anna Kowalska");


        hotelManager.listRooms();
        String expected_output = "Room number 101, Vacant, Floor 1\nRoom number 102, Vacant, Floor 1\nRoom number 103, Vacant, Floor 1\nRoom number 201, Vacant, Floor 2\nRoom number 202, Vacant, Floor 2\nRoom number 203, Vacant, Floor 2\nRoom number 301, Occupied by Anna Kowalska, Floor 3\nRoom number 302, Vacant, Floor 3\nRoom number 303, Vacant, Floor 3";


        assertEquals(expected_output, outContent.toString().replaceAll("\r\n", "\n").trim());

        // trim() usówa white space characters
        //replaceAll("\r\n", "\n") zastępuje wszystkie \r\n, które domyślnie się pojawiają, na \n
    }



    @Test
    void testViewRoom() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {

            Room room = new Room(101);
            room.setGuestName("Anna Kowalska");

            String input = "101\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            HotelManager hotelManager = new HotelManager();
            hotelManager.myMap.remove(101);
            hotelManager.myMap.put(101, room);


            hotelManager.viewRoom();

            String expectedOutput = "Room number " + 101 + ". This room is occupied by Anna Kowalska.";
            assertEquals(expectedOutput, outContent.toString().replaceAll("\r\n", "\n").trim());

        } finally {
            // Reset System.out to the original stream to avoid interference with other tests
            System.setOut(System.out);
        }


    }

    @Test
    void testViewRoomInvalid() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try{
            String input1 = "104\n";
            InputStream in1 = new ByteArrayInputStream(input1.getBytes());
            System.setIn(in1);

            HotelManager hotelManager = new HotelManager();
            hotelManager.viewRoom();

            String expectedOutput1 = "Invalid room number.";
            assertEquals(expectedOutput1, outContent.toString().replaceAll("\r\n", "\n").trim());
        }finally {
            // Reset System.out to the original stream to avoid interference with other tests
            System.setOut(System.out);
        }
    }
}
