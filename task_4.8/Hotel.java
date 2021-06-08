public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms() {     // Список свободных комнат
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber() + ", ";
        }
        if (freeRoomsList.equals("")) System.out.println("Свободных номеров нет. Покиньте отель.");
        else System.out.println("Номера свободных комнат " + freeRoomsList);
        System.out.print("\n");
    }

    public void reserveRoom(byte roomNumber) {       // Заселение комнаты
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber && room.isFree()) {
                room.setFree(false);
                info = ("Комната номер " + roomNumber + " успешно забронирована");
                break;
            } else if (room.getRoomNumber() == roomNumber && !room.isFree()) {
                info = "Комната " + roomNumber + " уже занята";
                break;
            }
        }
        System.out.println(info);
        System.out.print("\n");
    }

    public void evictionRoom(byte roomNumber) {      // Освобождение комнаты
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber && !room.isFree()) {
                room.setFree(true);
                info = ("Комната номер " + roomNumber + " успешно освобождена");
                break; }
            else if (room.getRoomNumber() == roomNumber && room.isFree()) {
                info = "Комната " + roomNumber + " не была заселена";
                break; }
        }
        System.out.println(info);
        System.out.print("\n");
    }

    public void descriptionsRoom(byte roomNumber) {      // Свойства комнаты
        String info = "Такой комнаты не существует";
        boolean isError = true;
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber) {
                isError = false;
                System.out.println("Свойства комнаты №" + roomNumber);
                room.getDescriptions();
                break; }
        }
        if (isError) System.out.println(info);
        System.out.print("\n");
    }

    public void getWiFi() {      // Комнаты с WiFi
        String WiFiRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWifi()) WiFiRoomsList += rooms[i].getRoomNumber() + ", ";
        }
        System.out.println("Номера комнат с Wi-Fi " + WiFiRoomsList);
        System.out.print("\n");
    }

    public void getWC() {        // Комнаты с сан.узлом
        String WCRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) WCRoomsList += rooms[i].getRoomNumber() + ", ";
        }
        System.out.println("Номера комнат с наличием сан.узла " + WCRoomsList);
        System.out.print("\n");
    }

    public void getEat() {       // Комнаты с включенным питанием
        String EatRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isEat()) EatRoomsList += rooms[i].getRoomNumber() + ", ";
        }
        System.out.println("Номера комнат с включенным питанием " + EatRoomsList);
        System.out.print("\n");
    }

    public void getQuantityBed() {        // Комнаты по кол-ву мест
        String quantity1RoomsList = "";
        String quantity2RoomsList = "";
        String quantity3RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getQuantity() == 1)
                quantity1RoomsList += rooms[i].getRoomNumber() + ", ";
            else if (rooms[i].getQuantity() == 2)
                quantity2RoomsList += rooms[i].getRoomNumber() + ", ";
            else
                quantity3RoomsList += rooms[i].getRoomNumber() + ", ";
        }
        System.out.println("1-комнатные номера " + quantity1RoomsList);
        System.out.println("2-комнатные номера " + quantity2RoomsList);
        System.out.println("3-комнатные номера " + quantity3RoomsList);
        System.out.print("\n");
    }
}