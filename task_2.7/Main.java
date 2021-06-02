/*
Задание: Дано число, например 31. Проверьте, что это число не делится ни на одно другое число кроме себя самого и единицы.
То есть в нашем случае нужно проверить, что число 31 не делится на все числа от 2 до 30. Если число не делится - выведите 'false',
а если делится - выведите 'true'.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = scan.nextInt();
        int i = 2;

        while (i<a) {
            if (a%i==0) {
                System.out.println("true");
                break;
            }
            else if (i+1==a) {
                System.out.println("false");
                break;
            }
            else i++;
        }
    }
}
