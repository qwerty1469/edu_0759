/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите 1-ое число: ");
        int a = scan.nextInt();
        System.out.print("Введите 2-ое число: ");
        int b = scan.nextInt();
        System.out.print("Результат сравнения: ");
        System.out.println(compare(a, b));
    }

    public static String compare (int a, int b){
        if (a==b) return "true";
        else return "false";
    }
}