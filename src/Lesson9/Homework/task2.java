package Lesson9.Homework;

public class task2 {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        task1.clearScreen();
        Integer[] integerArray = {1, 2, 3, 4, 5};
        printArray(integerArray);

        String[] stringArray = {"Hello", "World", "!"};
        printArray(stringArray);
    }
}
