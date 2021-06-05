/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
        Cat kot1 = new Cat();
        Cat kot2 = new Cat();
        Cat kot3 = new Cat();
        kot1.age = 4;
        kot1.weight = 3100;
        kot1.strength = 87;

        kot2.age = 7;
        kot2.weight = 4700;
        kot2.strength = 61;

        kot3.age = 7;
        kot3.weight = 4700;
        kot3.strength = 61;

        System.out.println(kot1.fight(kot2)); // kot1 проиграет kot2 -false
        System.out.println(kot2.fight(kot1)); // kot1 выиграет kot2 -true
        System.out.println(kot2.fight(kot3)); // ничья -true
        System.out.println(kot3.fight(kot2)); // ничья -true
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int resCat1 = 0;
        int resCat2 = 0;
        if (this.age > anotherCat.age) {
            System.out.println("По возрасту 1-ый выиграл");
            resCat1++;
        }
        else if (this.age == anotherCat.age) {
            System.out.println("Возрасты равны. Ничья");
            resCat1++;
            resCat2++;
        }
        else {
            System.out.println("По возрасту 2-ой выиграл");
            resCat2++;
        }

        if (this.weight > anotherCat.weight) {
            System.out.println("По весу 1-ый выиграл");
            resCat1++;
        }
        else if (this.weight == anotherCat.weight) {
            System.out.println("Веса равны. Ничья");
            resCat1++;
            resCat2++;
        }
        else {
            System.out.println("По весу 2-ой выиграл");
            resCat2++;
        }

        if (this.strength > anotherCat.strength) {
            System.out.println("По силе 1-ый выиграл");
            resCat1++;
        }
        else if (this.strength == anotherCat.strength) {
            System.out.println("Силы равны. Ничья");
            resCat1++;
            resCat2++;
        }
        else {
            System.out.println("По силе 2-ой выиграл");
            resCat2++;
        }

        System.out.println("Кол-во очков у кота 1: "+resCat1);
        System.out.println("Кол-во очков у кота 2: "+resCat2);

        if (resCat1 > resCat2) return true;
        else return resCat1 == resCat2;
    }
}