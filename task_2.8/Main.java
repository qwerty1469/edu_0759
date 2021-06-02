/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5};
        int product = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            product *= numbers[i];
        }
        System.out.println(product);
    }
}
