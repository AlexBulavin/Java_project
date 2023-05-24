package Lesson5;

public class lesson4 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Барсик";
        cat.birthyear = 2020;
        cat.gender = true;
        cat.vendor_phone = "123456";

        cat.visit("21042023", "Вытащили занозу");
        cat.visit("21052023", "Всё отлично, кот здоров");

        cat.printVisits();
        cat.miay();
    }
}
