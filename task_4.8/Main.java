import java.util.Scanner;

/*
*  ***Гостиница***
*  1) Гостиница
*  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
*
*   *Задание для лабораторной работы №4*
*   Освободить комнату
*   Вывести свойства комнаты
*   Показать комнаты с WiFi
*   Показать комнаты с WC
*   Показать комнаты с Eat
*   Показать комнаты по кол-ву спальных мест
*   Отобразить список команд
* */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Приветствуем в отеле Hotel. Для отображения всех доступных команд введите \"0\".");
        while (true){
            System.out.println("Введите команду:");
            command = scanner.nextLine();
            if (command.equals("0")) {
                System.out.println("Список команд: "    +"\n"+
                        "1 - Свободные комнаты"         +"\n"+                      // getFreeRooms
                        "2 - Заселить комнату"          +"\n"+                      // reserveRoom
                        "3 - Освободить комнату"        +"\n"+                      // evictionRoom
                        "4 - Свойства комнаты"          +"\n"+                      // descriptionsRoom
                        "5 - Показать комнаты с WiFi"   +"\n"+                      // getWiFi
                        "6 - Показать комнаты с WC"     +"\n"+                      //
                        "7 - Показать комнаты с Eat"    +"\n"+                      //
                        "8 - Показать комнаты по кол-ву спальных мест"  +"\n"+      //
                        "exit - Выйти из программы"     +"\n"+                      // Выход
                        "--------------------------------------------");
            }
            else if (command.equals("1")) {     // Свободные комнаты
                hotel.getFreeRooms(); }

            else if (command.equals("2")) {     // Заселить комнату
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
                scanner.nextLine(); }

            else if (command.equals("3")) {     // Освободить комнату
                System.out.print("Введите номер комнаты для освобождения: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.evictionRoom(roomNumber);
                scanner.nextLine(); }

            else if (command.equals("4")) {     // Свойства комнаты
                System.out.print("Введите номер комнаты: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.descriptionsRoom(roomNumber);
                scanner.nextLine(); }

            else if (command.equals("5")) {     // Показать комнаты с WiFi
                hotel.getWiFi(); }

            else if (command.equals("6")) {     // Показать комнаты с WiFi
                hotel.getWC(); }

            else if (command.equals("7")) {     // Показать комнаты с WiFi
                hotel.getEat(); }

            else if (command.equals("8")) {     // Показать комнаты по кол-ву мест
                hotel.getQuantityBed(); }

            else if (command.equals("exit")) {
                break;
            }
            else System.out.println("Команды не существует");
        }

    }
}
