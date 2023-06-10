package Lesson10.Seminar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        this.scanner = new Scanner(System.in);
    }

    public double getInputNumber(String msg) {
        while (true) {
            try {
                System.out.print("Введите " + msg + " число в виде 1,5: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода!\t Введите числов виде 1,5");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }
    }

    public char getInputOperator() {
        System.out.print("Введите оператор (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
