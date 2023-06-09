package Lesson9.Homework;

public class task1 {
    public static <T> void printElement(T element) {
        System.out.println(element);
    }

    public static void main(String[] args) {
        clearScreen();
        Integer integerElement = 10;
        printElement(integerElement);

        String stringElement = "Hello, world!";
        printElement(stringElement);

        Double doubleElement = 3.14;
        printElement(doubleElement);
    }

        /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
