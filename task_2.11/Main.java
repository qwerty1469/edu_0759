/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
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
        int j = 0;
        int sum = 0;
        while (j<sizeArray) {
            sum +=myArray[j];
            if (sum>10) {
                System.out.println("Необходимо "+(j+1)+" первых элементов массива");
                break;
            }
            else if (j+1==sizeArray) {
                System.out.println("Сумма всех элементов меньше 10");
                break;
            }
            else j++;
        }
    }
}
