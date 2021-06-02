/*
Задание: Запросить у пользователя ввод числа и сохранить это число в переменную a.Если переменная a равна 10, то выведите 'Верно', иначе выведите 'Неверно'.
*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");

        if (scan.hasNextDouble()) {
            double a = scan.nextDouble();
            if (a == 10)
                System.out.println("Верно");
            else
                System.out.println("Неверно");
        }
        else System.out.println("Это не число!");
    }
}
