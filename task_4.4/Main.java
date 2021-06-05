/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5, "Brown");
        Dog bigDog = new Dog("Бульдог", 9, 21.8, "Grey");
        Cat tomCat = new Cat("Tom", 120, "Dark grey");
    }
}
class Mouse {
    String name;
    int height;
    int tail;
    String colour;

    public Mouse(String name, int height, int tail, String colour) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}

class Dog {
    String name;
    int age;
    double weight;
    String colour;

    public Dog(String name, int age, double weight, String colour) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Cat {
    String name;
    int height;
    String colour;

    public Cat(String name, int height, String colour) {
        this.name = name;
        this.height = height;
        this.colour = colour;
    }
}