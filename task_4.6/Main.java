/*
Задача вывести на экран такое сообщение (для объекта gosha):
Меня зовут "имя объекта"
Имя моей мамы: "имя мамы"
Имя моего папы: "имя папы"
У меня две бабушки, бабушка "имя бабушки" и "имя бабушки"
У меня два деда, деда "имя деда" и "имя деда"
*/

public class Main {
    public static void main(String[] args) {
        Person valera=new Person("Валера","Иванов",69,null,null);
        Person olga = new Person("Ольга","Иванова",67,null,null);
        Person oleg = new Person("Олег","Петров",65,null,null);
        Person jula = new Person("Юля","Петрова",67,null,null);
        Person alex = new Person("Алексей","Иванов",37,olga,valera);
        Person eva  = new Person("Ева","Иванова",37,jula,oleg);
        Person gosha= new Person("Гоша","Иванов",10,eva,alex);
//        System.out.println("Мама Алексея: "+alex.getMother().getName());
//        System.out.println("Бабушка Гоши: "+gosha.getMother().getMother().getName());

//        System.out.println("Меня зовут: "+gosha.getName()); // Меня зовут
//        System.out.println("Имя моей мамы: "+gosha.getMother().getName()); // Имя моей мамы
//        System.out.println("Имя моего папы: "+gosha.getFather().getName()); // Имя моего папы
//        System.out.println("У меня две бабушки, бабушка "+gosha.getMother().getMother().getName()); // У меня две бабушки, бабушка "имя бабушки" и "имя бабушки"
//        System.out.println("и "+gosha.getFather().getMother().getName());
//        System.out.println("У меня два деда, дед "+gosha.getMother().getFather().getName()); // У меня два деда, деда "имя деда" и "имя деда"
//        System.out.println("и "+gosha.getFather().getFather().getName());

        gosha.getInfo();
    }
}

class Person {
    private String name;
    private String lastname;
    private int age;
    private int hp = 100;
    private Person mother;
    private Person father;

    public Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }


    public void Print(Person value) {
        System.out.println(value.mother);
    }

    public void infoGrandMother(Person valueMother, Person valueFather) {
        String info;
        if (valueMother != null && valueFather != null) {
            info = "У меня две бабушки"+"\n"+
                    "Мою бабушку по линии мамы зовут "+valueMother.name+"\n"+
                    "Мою бабушку по линии папы зовут "+valueFather.name;
            System.out.println(info); }
        else if (valueMother != null || valueFather != null) {
            info = "У меня одна бабушка"+"\n";
            if (valueMother != null)
                info = "Мою бабушку по линии мамы зовут "+valueMother.name;
            else
                info = "Мою бабушку по линии папы зовут "+valueFather.name;
            System.out.println(info); }
    }

    public void infoGrandFather(Person valueMother, Person valueFather) {
        String info;
        if (valueMother != null && valueFather != null) {
            info = "У меня два деда"+"\n" +
                    "Моего деда по линии мамы зовут "+valueMother.name+"\n"+
                    "Моего деда по линии папы зовут "+valueFather.name;
            System.out.println(info); }
        else if (valueMother != null || valueFather != null) {
            info = "У меня один дед"+"\n";
            if (valueMother != null)
                info = "Моего деда по линии мамы зовут "+valueMother.name;
            else
                info = "Моего деда по линии папы зовут "+valueFather.name;
            System.out.println(info); }
    }

    public void getInfo() {
        System.out.println("Меня зовут " + this.name);
        if (this.mother != null && this.father != null) {
            System.out.println("Имя моей мамы "+this.mother.name+"\n"+
                    "Имя моего папы "+this.father.name);
            infoGrandMother(this.mother.mother, this.father.mother);
            infoGrandFather(this.mother.father, this.father.father);
        } else if (this.mother != null || this.father != null) {
            if (this.mother != null) {
                System.out.println("Имя моей мамы "+this.mother.name);
                this.infoGrandMother(this.mother.mother, null);
                this.infoGrandFather(this.mother.father, null); }
            else {
                System.out.println("Имя моего папы "+this.father.name);
                this.infoGrandMother(null, this.father.mother);
                this.infoGrandFather(null, this.father.father); }
        }
    }

    public String getName() {
        return this.name;
    }

    public Person getMother(){
        return this.mother;
    }
    public Person getFather(){
        return this.father;
    }

}
