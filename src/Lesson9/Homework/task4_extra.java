package Lesson9.Homework;

import java.util.Comparator;

public class task4_extra {
    public class Main {

        public static void main(String[] args) {

            task1.clearScreen();

            DataContainer<String> container = new DataContainer<>();
            container.add("Apple");
            container.add("Banana");
            container.add("Orange");
            container.add("Mango");
            container.add("Pineapple");
            container.add("Grape");
            container.add("Watermelon");
            container.add("Strawberry");
            container.add("Cherry");
            container.add("Peach");
            container.add("Kiwi");
            container.add("Pear");
            container.add("Lemon");
            container.add("Blueberry");
            container.add("Raspberry");
            container.add("Plum");

            System.out.println("Original elements:");
            container.print();

            System.out.println("Sorted elements:");
            container.sort(Comparator.reverseOrder());
            container.print();
        }
    }
}
