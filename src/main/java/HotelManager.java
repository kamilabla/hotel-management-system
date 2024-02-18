import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;


public class HotelManager {
    MyMap <Integer, Room> myMap = new MyMap<>();
    private final Scanner scanner = new Scanner(System.in);

    private static final String ACTION_1 = "Room number ";

    public HotelManager() {
        IntStream.of(101, 102, 103, 201, 202, 203, 301, 302, 303)
                .forEach(roomNumber -> myMap.put(roomNumber, new Room(roomNumber)));
    }

    /**
     * Metoda listujaca wszystkie dostepne pokoje i informacje z nimi zwiazane
     * Podaje numer pokoju, imie i nazwisko goscia oraz pietro
      */
    public void listRooms(){
        for (int room_number : myMap.keys()){
            int floor = room_number/100;
            Room room = myMap.get(room_number);
            if (room.getGuestName() != null) System.out.println(ACTION_1 + room_number + ", Occupied by " + room.getGuestName() + ", Floor " + floor);
            else System.out.println(ACTION_1 + room_number + ", Vacant, Floor " + floor);
        }
    }

    /**
     * Metoda printująca informacje o danym pokoju
     * Pobiera numer pokoju
     * W razie, gdyby pokoj nie istnial zwraca odpowiedni komunikat
      */
    public void viewRoom(){
        System.err.print("Enter room number: ");   // jeśli się nie da err to w testach też będzie printować "Enter room number: "
        int room_number = scanner.nextInt();

        Room room = myMap.get(room_number);

        if (room != null) System.out.println(ACTION_1 + room_number + ". " + (room.getGuestName() != null ? "This room is occupied by " + room.getGuestName() + "." : "This room is vacant."));
        else System.out.println("Invalid room number.");
    }
    /**
     * Metoda zakwaterowujaca goscia
     * Pobiera numer pokoju goscia oraz imie i nazwisko
     * W przypadku, gdy pokoj nie istnieje lub jest zajety zwracany jest odpowiedni komunikat
     */
    public void checkInGuest(){
        System.err.print("Enter room number for the guest: ");
        int room_number = scanner.nextInt();
        Room room = myMap.get(room_number);

        // For the newline character, so that it doesn't go to nextLine()
        scanner.nextLine();

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (room.getGuestName() == null){
            System.out.println("Enter the name of your guest: ");
            String guest_name = scanner.nextLine();
            room.setGuestName(guest_name);
            System.out.println("Guest was successfully checked in.");
        }
        else{
            System.out.println("This room is occupied.");
        }
    }

    /**
     * Metoda wykwaterowuje goscia
     * Pobiera numer pokoju goscia
     * W przypadku, gdy pokoj nie istnieje lub nie jest zajety zwracany jest odpowiedni komunikat
     */
    public void checkOutGuest(){

        System.out.println("Enter room number of your guest: ");
        int room_number = scanner.nextInt();
        Room room = myMap.get(room_number);

        if (room != null && room.getGuestName() != null){
            room.setGuestName(null);
            System.out.println("Guest was successfully checked out.");
        } else {
            System.out.println("Invalid room number or room is not occupied.");
        }
    }
    /**
     * Zapis do pliku CSV
     * W wypadku braku mozliwosci zapisania do pliku obslugiwany jest wyjatek
     */
    public void saveToFile()throws IOException {
        String filePath = "C:\\Users\\kamil\\OneDrive\\Pulpit\\Programy 2\\hotel.csv";
        try (FileWriter fileWriter = new FileWriter(filePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("Room Number", "Guest Name", "Floor"))){

            for (int key : myMap.keys()){
                Room room = myMap.get(key);
                csvPrinter.printRecord(room.getRoomNumber(), room.getGuestName(), room.getRoomNumber()/100);
            }
        }
    }

}
