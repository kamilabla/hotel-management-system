import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        /**
         * Petla pobierajaca komendy, az do podania komendy 'exit'
         */
        while (b){
            System.out.println("Available commands: list, view, checkin, checkout, save, exit");
            System.out.println("Enter your command: ");
            String com = scanner.nextLine().toLowerCase();

            switch (com){
                case "list":
                    hotelManager.listRooms();
                    break;
                case "view":
                    hotelManager.viewRoom();
                    break;
                case "checkin":
                    hotelManager.checkInGuest();
                    break;
                case "checkout":
                    hotelManager.checkOutGuest();
                    break;
                case "save":
                    try {
                        hotelManager.saveToFile();
                        System.out.println("Data saved to CSV successfully.");
                        break;
                    } catch (IOException e) {
                        System.err.println("Error saving data to CSV: " + e.getMessage());
                    }
                case "exit":
                    System.out.println("Exiting hotel manager.");
                    b = false;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}
