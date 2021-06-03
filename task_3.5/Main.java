/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};
        System.out.print("Элементы массива: ");
        elArray(num, 0);
    }

    public static void elArray(int array[], int i) {
        System.out.print(String.valueOf(array[i]));
        i++;
        if (i < array.length) {
            System.out.print(" ");
            elArray(array, i);
        }
    }
}
