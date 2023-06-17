package Lesson11.Homework.Task4MVPandSOLID;

public class Task1ClearScreen {
    public static void main(String[] args) {
        clearScreen();
        Task1.main(args);
    }

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}