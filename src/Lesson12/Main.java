package Lesson12;

public class Main {
    
}


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// Класс, представляющий комплексное число
class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

// Интерфейс для калькулятора
interface CalculatorView {
    void displayResult(ComplexNumber result);
    void displayError(String message);
}

// Класс, реализующий представление калькулятора
class CalculatorActivity implements CalculatorView {
    private Logger logger;
    
    public CalculatorActivity(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void displayResult(ComplexNumber result) {
        logger.log(Level.INFO, "Результат: " + result.getReal() + " + " + result.getImaginary() + "i");
    }

    @Override
    public void displayError(String message) {
        logger.log(Level.SEVERE, message);
    }
}

// Интерфейс для калькулятора презентера
interface CalculatorPresenter {
    void add(ComplexNumber num1, ComplexNumber num2);
    void subtract(ComplexNumber num1, ComplexNumber num2);
    void multiply(ComplexNumber num1, ComplexNumber num2);
    void divide(ComplexNumber num1, ComplexNumber num2);
}

// Класс, реализующий калькулятор презентера
class CalculatorPresenterImpl implements CalculatorPresenter {
    private CalculatorView view;
    
    public CalculatorPresenterImpl(CalculatorView view) {
        this.view = view;
    }

    @Override
    public void add(ComplexNumber num1, ComplexNumber num2) {
        double realResult = num1.getReal() + num2.getReal();
        double imaginaryResult = num1.getImaginary() + num2.getImaginary();
        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);
        view.displayResult(result);
    }

    @Override
    public void subtract(ComplexNumber num1, ComplexNumber num2) {
        double realResult = num1.getReal() - num2.getReal();
        double imaginaryResult = num1.getImaginary() - num2.getImaginary();
        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);
        view.displayResult(result);
    }

    @Override
    public void multiply(ComplexNumber num1, ComplexNumber num2) {
        double realResult = (num1.getReal() * num2.getReal()) - (num1.getImaginary() * num2.getImaginary());
        double imaginaryResult = (num1.getReal() * num2.getImaginary()) + (num1.getImaginary() * num2.getReal());
        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);
        view.displayResult(result);
    }

    @Override
    public void divide(ComplexNumber num1, ComplexNumber num2) {
        double divisor = (num2.getReal() * num2.getReal()) + (num2.getImaginary() * num2.getImaginary());
        if (divisor != 0) {
            double realResult = ((num1.getReal() * num2.getReal()) + (num1.getImaginary() * num2.getImaginary())) / divisor;
            double imaginaryResult = ((num1.getImaginary() * num2.getReal()) - (num1.getReal() * num2.getImaginary())) / divisor;
            ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);
            view.displayResult(result);
        } else {
            view.displayError("Ошибка: деление на ноль");
        }
    }
}

// Главный класс приложения
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Calculator");
        CalculatorView view = new CalculatorActivity(logger);
        CalculatorPresenter presenter = new CalculatorPresenterImpl(view);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите комплексное число 1 (в формате a+bi):");
        ComplexNumber num1 = parseComplexNumber(scanner.nextLine());

        System.out.println("Введите комплексное число 2 (в формате a+bi):");
        ComplexNumber num2 = parseComplexNumber(scanner.nextLine());

        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");

        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                presenter.add(num1, num2);
                break;
            case 2:
                presenter.subtract(num1, num2);
                break;
            case 3:
                presenter.multiply(num1, num2);
                break;
            case 4:
                presenter.divide(num1, num2);
                break;
            default:
                System.out.println("Ошибка: некорректная операция");
        }
    }

    private static ComplexNumber parseComplexNumber(String input) {
        String[] parts = input.split("\\+");
        double real = Double.parseDouble(parts[0]);
        double imaginary = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
        return new ComplexNumber(real, imaginary);
    }
}
