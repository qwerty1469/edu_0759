/*
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
Требования:
•	Программа не должна считывать данные с клавиатуры.
•	У класса Dog должна быть переменная name с типом String.
•	У класса Dog должна быть переменная age с типом int.
•	У класса должен быть сеттер для переменной name.
•	У класса должен быть геттер для переменной name.
•	У класса должен быть сеттер для переменной age.
•	У класса должен быть геттер для переменной age.
*/


public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        System.out.println(dog1.getName()+" "+dog1.getAge());
        dog1.setName("Бобик старый");
        dog1.setAge(dog1.age + 5);
        System.out.println(dog1.getName()+" "+dog1.getAge());
//        System.out.println(dog1.getName()+" "+dog1.getAge());
    }
}

class Dog {
    String name = "Бродячая"; // Кличка
    int age = 4; // Возраст

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }
    void setAge(int age) {
        this.age = age;
    }

}

