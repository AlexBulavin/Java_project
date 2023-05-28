package Lesson6.Homework_Seminar1.task1;

public class Main {
    public static void main(String[] args) {
        clearScreen();
        Cat cat = new Cat("Мурзик", 5);
        Owner owner = new Owner("Иван");

        cat.setOwner(owner);

        cat.greet();

        System.out.println();
    }

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
