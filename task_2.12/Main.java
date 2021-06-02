/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] myArray = new int[10];
        int numb = 0;
        while (numb<myArray.length) {
            System.out.print("Введите "+(numb+1)+" число: ");
            myArray[numb] = scan.nextInt();
            numb++;
        }

        int maxLen = 0;
        int i = 0;
        while (i < myArray.length) {
            int count = 1;
            while (myArray[i]==myArray[i+1]) {
                count++;
                if (i+2==myArray.length) break;
                else i++;
            }
            if (maxLen < count) maxLen = count;
            if (i+2==myArray.length) break;
            else i++;
        }
        System.out.println("Длина самой длинной последовательности = "+maxLen);
    }
}