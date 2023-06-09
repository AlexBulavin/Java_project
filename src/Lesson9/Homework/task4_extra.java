package Lesson9.Homework;

import java.util.Comparator;

public class task4_extra {

    public static void main(String[] args) {

        task1.clearScreen();

        DataContainer<String> container = new DataContainer<>();
        container.add("Арбуз");
        container.add("Клубника");
        container.add("Малина");
        container.add("Слива");
        container.add("Ананас");
        container.add("Груша");
        container.add("Персик");
        container.add("Апельсин");
        container.add("Манго");
        container.add("Лимон");
        container.add("Киви");
        container.add("Виноград");
        container.add("Вишня");
        container.add("Голубика");
        container.add("Банан");
        container.add("Яблоко");

        System.out.println("Оригинальные элементы:");
        container.print();

        System.out.println("\nОтсортированные в обратном порядке элементы:");
        container.sort(Comparator.reverseOrder());
        container.print();
    }

}
