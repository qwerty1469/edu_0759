/*
* Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
* Коллекции вы создаёте сами
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String value = "";
        int i = 0;
        System.out.println("Введите числа. Для выхода введите пустую строку");
        while (true) {
            value = scan.nextLine();
            if (value.isEmpty())
                break;
            i++;
            intList.add(Integer.valueOf(value));
        }
        List<Integer> newIntList = new ArrayList<>(i);

        for (int j = 0; j < intList.size(); j++) {
            if (intList.get(j) > 0 && intList.get(j) < 10) {
                newIntList.add(intList.get(j));
            }
        }
        System.out.println(newIntList);
    }
}
