# Hotel Management System

## Opis projektu

Jest to aplikacja konsolowa napisana w języku **Java**, umożliwiająca zarządzanie hotelem. Program obsługuje zameldowanie, wymeldowanie gości, przeglądanie informacji o pokojach oraz zapis danych do pliku CSV. 

Projekt składa się z kilku klas odpowiadających za różne funkcjonalności, a także zestawu testów jednostkowych.

---

## Funkcjonalności

- **Start**: Na starcie program prosi o podanie jednej z dostępnych komend.
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/de363e66-6e81-43e5-91d5-a3cb33a821ce">

- **Zameldowanie gościa**: Komenda `checkin` umożliwia przypisanie gościa do konkretnego pokoju.
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/32a58df0-26b5-4864-b38b-b914185cfa58">

- **Wymeldowanie gościa**: Komenda `checkout` usuwa dane gościa z pokoju.
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/2f28383c-12d7-47f9-9017-de80494dc5e5">

- **Wylistowanie pokoi**: Komenda `list` wypisuje wszystkie dostępne pokoje z informacjami o:
  - numerze pokoju
  - imieniu i nazwisku gościa
  - piętrze, na którym znajduje się pokój 
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/f0161232-b5dd-43fc-9f99-1c96ae94eca1">

- **Szczegóły pokoju**: Komenda `view` pokazuje szczegółowe informacje o wybranym pokoju.
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/18ee1cb0-f29a-4ff5-8011-d75263fdc944">

- **Zapis danych**: Komenda `save` zapisuje dane wszystkich pokoi do pliku CSV.
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/333f3ec1-7f95-432c-82ed-69f55b80547c">

- **Wyjście z programu**: Komenda `exit` kończy działanie aplikacji. <br/>
  <img width="500" alt="image" src="https://github.com/user-attachments/assets/55820d55-c3d3-4678-89ea-158cf6600534">


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

## Autorzy

- **[Kamila Błaszczyna]**  [Twój profil GitHub](https://github.com/kamilabla)  


