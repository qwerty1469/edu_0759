/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int sizeArray = scan.nextInt();
        int[] myArray = new int[sizeArray];
        int i = 0;
        while (i<sizeArray) {
            System.out.print("Введите "+(i+1)+" число: ");
            myArray[i] = scan.nextInt();
            i++;
        }
        for (int j = 0; j < sizeArray; j++) {
            if (myArray[j] == 5) {
                System.out.println("Да");
                break;
            }
            else if (j+1==i) System.out.println("Нет");
            else continue;
        }
    }
}
