/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main{

    public static void main(String[] args) {
      Horse loshad = new Horse(14, (byte) 4, "Черно-белый", "Большой", "Русская верховая");
      Pegasus pegas = new Pegasus(10, (byte) 4, "Белый", "Большой", "-", "Белый");
      loshad.run();
      pegas.fly();
    }
}

abstract class Animal {
    int age;
    byte paws; // кол-во лап
    String colour;
    String size; // размер

    Animal(int age, byte paws, String colour, String size) {
        this.age = age;
        this.paws = paws;
        this.colour = colour;
    }

}

class Horse extends Animal {
    String breed; // порода
    Horse(int age, byte paws, String colour, String size, String breed){
        super(age, paws, colour, size);
        this.breed = breed;
    }
    public void run(){
        System.out.println("Игого, я поскакал(а)");
    }
}

class Pegasus extends Horse {
    String wingColour;
    Pegasus(int age, byte paws, String colour, String size, String breed, String wingColour){
        super(age, paws, colour, size, breed);
        this.wingColour = wingColour;
    }
    public void fly(){
        System.out.println("Игого, я полетел(а)");
    }
}