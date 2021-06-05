/*
Помогите коту обрести имя с помощью метода setName.
Требования:
•	Класс Cat должен содержать только одну переменную name.
•	Переменная name должна иметь модификатор доступа private и тип String.
•	Метод setName класса Cat должен устанавливать значение переменной private String name равным переданному параметру String name.
*/


public class Main {
    public static void main(String[] args) {
        Cat myrzik = new Cat();
        System.out.println(myrzik.getName()); //имя созданного кота
//        System.out.println(cat.name);
        myrzik.setName("Жужик");
        System.out.println(myrzik.getName()); //проверка нового имени
    }
}

class Cat {
    private String name = "безымянный кот";

    String getName() {
        return name;
    }

    void setName (String name) {
        this.name = name;
    }
}
