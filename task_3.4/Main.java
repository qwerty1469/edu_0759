/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.

*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите 1-ое число: ");
        int a = scan.nextInt();
        System.out.print("Введите 2-ое число: ");
        int b = scan.nextInt();
        System.out.print("Сумма больше 10: ");
        System.out.println(sum(a, b));
    }

    public static String sum(int a, int b){
        if (a + b > 10) return "true";
        else return "false";
    }
}