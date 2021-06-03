/* Написать функцию, которая вычисляет минимум из трёх чисел.
Требования:
•	Программа должна выводить текст на экран.
•	Метод min не должен выводить текст на экран.
•	Метод main должен вызвать метод min четыре раза.
•	Метод main должен выводить на экран результат работы метода min. Каждый раз с новой строки.
•	Метод min должен возвращать минимальное значение из чисел a, b и с.
*/


public class Main {
    public static int min(int a, int b, int c) {
        int minNumb1 = 0;
        int minNumb2 = 0;
        if (a < b) minNumb1 = a;
        else minNumb1 = b;
        if (b < c) minNumb2 = b;
        else minNumb2 = c;
        if (minNumb1 < minNumb2) return minNumb1;
        else return minNumb2;
    }

    public static void main(String[] args) {
        System.out.println( String.valueOf(min(1, 2, 3)) );
        System.out.println( String.valueOf(min(-1, -2, -3)) );
        System.out.println( String.valueOf(min(3, 5, 3)) );
        System.out.println( String.valueOf(min(5, 5, 10)) );

//        System.out.println(String.valueOf(123)+3);
    }
}
