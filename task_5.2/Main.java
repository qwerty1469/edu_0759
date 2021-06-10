/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        list.add("Москва");
        list.add("Ивановы");
        list.add("Киев");
        list.add("Петровы");
        list.add("Лондон");
        list.add("Абрамовичи");

        System.out.println("Укажите Город, а затем Фамилию");
        while (true) {
            String cityFamily = scanner.nextLine();
            if (cityFamily.isEmpty()) {
                break;
            }
            list.add(cityFamily);
        }

        // Read the city
        System.out.println("Для поиска фамилии введите город: ");
        String city = scanner.nextLine();

        if (list.contains(city)) {
            String familyName = list.get(list.indexOf(city)+1);
            System.out.println(familyName);
        }
        else System.out.println("Фамилия не найдена.");
    }
}
