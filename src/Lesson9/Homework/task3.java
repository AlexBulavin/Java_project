package Lesson9.Homework;

public class task3 {
    public static <T extends Comparable<T>> T getMax(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void main(String[] args) {
        task1.clearScreen();
        int a, b;
        a = 10;
        b = 5;
        Integer intResult = getMax(a, b);
        System.out.println("Максимальное значение из " + a + " и " + b + ": " + intResult);

        Double a1, b1;
        a1 = 3.14;
        b1 = 2.71;
        Double doubleResult = getMax(a1, b1);
        System.out.println("Максимальное значение из " + a1 + " и " + b1 + ": " + doubleResult);

        String a2 = "Hello";
        String b2 = "World";
        String stringResult = getMax(a2, b2);
        System.out.println("Максимальное значение из " + a2 + " и " + b2 + ": " + stringResult);
    }
}
