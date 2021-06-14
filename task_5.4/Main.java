/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        int i = Integer.parseInt("-2");
//        System.out.println(i + 1);
        try {
            FileInputStream fis = new FileInputStream("C://projava/test.txt"); // в файле указаны на каждой строке числа из примера, каретка после 10: 10|
            int i;
            String value = "";
            while (true) {
                i = fis.read();
                if (i == 13)
                    continue;
                else if (i == 10) {
                    if (Integer.parseInt(value)%2==0) {
                        System.out.println(value);
                        value = "";
                        continue;
                    }
                    else {
                        value = "";
                        continue;
                    }
                }
                if (i == -1){
                    if (Integer.parseInt(value)%2==0) {
                        System.out.println(value);
                        break;
                    }
                    else break;
                }
                value += (char) i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
