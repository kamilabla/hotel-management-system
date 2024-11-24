# Hotel Management System

## Opis projektu

Jest to aplikacja konsolowa napisana w języku **Java**, umożliwiająca zarządzanie hotelem. Program obsługuje zameldowanie, wymeldowanie gości, przeglądanie informacji o pokojach oraz zapis danych do pliku CSV. 

Projekt składa się z kilku klas odpowiadających za różne funkcjonalności, a także zestawu testów jednostkowych.

---

## Funkcjonalności

- **Zameldowanie gościa**: Komenda `checkin` umożliwia przypisanie gościa do konkretnego pokoju.

- **Wymeldowanie gościa**: Komenda `checkout` usuwa dane gościa z pokoju.
- **Wylistowanie pokoi**: Komenda `list` wypisuje wszystkie dostępne pokoje z informacjami o:
  - numerze pokoju
  - imieniu i nazwisku gościa
  - piętrze, na którym znajduje się pokój 

- **Szczegóły pokoju**: Komenda `view` pokazuje szczegółowe informacje o wybranym pokoju.
- **Zapis danych**: Komenda `save` zapisuje dane wszystkich pokoi do pliku CSV.
- **Wyjście z programu**: Komenda `exit` kończy działanie aplikacji.

---

## Struktura projektu

Projekt składa się z następujących plików:

### **Główne klasy**

- **`Main.java`**  
  Klasa główna obsługująca uruchomienie programu i przetwarzanie komend użytkownika:
  - `checkin`
  - `checkout`
  - `list`
  - `view`
  - `save`
  - `exit`

- **`HotelManager.java`**  
  Klasa odpowiedzialna za zarządzanie danymi o pokojach i gościach.

- **`MyMap.java`**  
  Niestandardowa implementacja mapy do przechowywania i zarządzania danymi.

- **`Room.java`**  
  Klasa reprezentująca pojedynczy pokój hotelowy, zawierająca informacje takie jak:
  - numer pokoju
  - dane gościa (imię i nazwisko)
  - piętro

### **Testy jednostkowe**

- **`HotelManagerTest.java`**  
  Testy jednostkowe dla klasy `HotelManager`.

- **`MyMapTest.java`**  
  Testy jednostkowe dla klasy `MyMap`.

- **`RoomTest.java`**  
  Testy jednostkowe dla klasy `Room`.

---

