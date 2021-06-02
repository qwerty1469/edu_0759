/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        double deposit = scan.nextDouble();
        System.out.print("Введите процент: ");
        double percent = scan.nextDouble();
        System.out.println("Внесена сумма "+deposit+" под "+percent+"% годовых");

        for (int i = 1; i < 6; i++) {
            deposit *= (1 + percent / 100);
            String result = String.format("%.4f",deposit);
            System.out.println("Размер вклада после " +i+" года равен "+result);
        }
    }
}
