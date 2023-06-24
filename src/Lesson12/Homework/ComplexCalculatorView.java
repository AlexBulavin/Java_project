package Lesson12.Homework;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List; 

public class ComplexCalculatorView {
    private Scanner scanner;

    public ComplexCalculatorView() {
        this.scanner = new Scanner(System.in);
    }

    public double getInputNumber(String msg) {
        while (true) {
            try {
                System.out.print("Введите " + msg + " часть числа в виде 1,5: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода!\t Введите число в виде 1,5");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }
    }

    public char getInputOperator() {
        System.out.print("Введите оператор (+, -, *, /, s, p): ");
        return scanner.next().charAt(0);
    }

    public void displayResult(ComplexNumber result) {
        double realPart = result.getReal();
        double imaginaryPart = result.getComplexity();

        String sign = imaginaryPart >= 0 ? "+" : "-"; // Определяем знак мнимой части

        System.out.println("Результат: " + realPart + " " + "i * " + sign + Math.abs(imaginaryPart) + "i");
    }

    public void displayHistory(List<String> history) {
        System.out.println("История операций:");
        for (String operation : history) {
            System.out.println(operation);
        }
    }

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

