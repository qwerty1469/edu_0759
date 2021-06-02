/*
Задание: Даны переменные a и b. Проверьте, что a делится без остатка на b. Если это так - выведите 'Делится' и результат деления,
иначе выведите 'Делится с остатком' и остаток от деления.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите 1-ое число: ");
        int a = scan.nextInt();
        System.out.print("Введите 2-ое число: ");
        int b = scan.nextInt();

        if (a%b == 0) System.out.println("Делится. Результат деления = "+a/b);
        else System.out.println("Делится с остатком. Остаток от деления = "+(double) a%b);
    }
}
