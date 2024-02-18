public class Room {
    private int roomNumber;
    private String guestName;

    /**
     * Klasa przechowujaca numer pokoju oraz imie i nazwisko goscia
     * @param roomNumber numer pokoju
     */
    public Room(int roomNumber){
        this.roomNumber = roomNumber;
    }

    /**
     * Metoda zwracajaca numer pokoju danej instancji klasy Room
     * @return zwrocenie
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Metoda zwracajaca imie i nazwisko goscia danego pokoju
     * @return
     */
    public String getGuestName() {
        return guestName;
    }
    /**
     * Metoda ustawiajaca imie i nazwisko goscia danego pokoju
     * @return
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
