package Lesson12.Homework;

import java.util.ArrayList;
import java.util.List;

public class ComplexCalculatorModel {
    private ComplexNumber result;
    private List<String> history;

    public ComplexCalculatorModel() {
        this.result = new ComplexNumber(0, 0);
        this.history = new ArrayList<>();
    }

    public void add(ComplexNumber number) {
        double realResult = result.getReal() + number.getReal();
        double complexityResult = result.getComplexity() + number.getComplexity();
        result = new ComplexNumber(realResult, complexityResult);
        history.add(String.format("Addition: %s + %s", number, result));
    }

    public void subtract(ComplexNumber number) {
        double realResult = result.getReal() - number.getReal();
        double complexityResult = result.getComplexity() - number.getComplexity();
        result = new ComplexNumber(realResult, complexityResult);
        history.add(String.format("Subtraction: %s - %s", number, result));
    }

    public void multiply(ComplexNumber number) {
        double realResult = (result.getReal() * number.getReal()) - (result.getComplexity() * number.getComplexity());
        double complexityResult = (result.getReal() * number.getComplexity()) + (result.getComplexity() * number.getReal());
        result = new ComplexNumber(realResult, complexityResult);
        history.add(String.format("Multiplication: %s * %s", number, result));
    }

    public void divide(ComplexNumber number) {
        double divisor = (number.getReal() * number.getReal()) + (number.getComplexity() * number.getComplexity());
        if (divisor != 0) {
            double realResult = ((result.getReal() * number.getReal()) + (result.getComplexity() * number.getComplexity())) / divisor;
            double complexityResult = ((result.getComplexity() * number.getReal()) - (result.getReal() * number.getComplexity())) / divisor;
            result = new ComplexNumber(realResult, complexityResult);
            history.add(String.format("Division: %s / %s", number, result));
        } else {
            throw new IllegalArgumentException("Ошибка: деление на ноль");
        }
    }

    public void squareRoot() {
        double realResult = Math.sqrt(result.getReal());
        double complexityResult = Math.sqrt(result.getComplexity());
        result = new ComplexNumber(realResult, complexityResult);
        history.add(String.format("Square Root: √%s = %s", result, result));
    }

    public void power(ComplexNumber number) {
        double realResult = Math.pow(result.getReal(), number.getReal());
        double complexityResult = Math.pow(result.getComplexity(), number.getComplexity());
        result = new ComplexNumber(realResult, complexityResult);
        history.add(String.format("Power: %s ^ %s = %s", result, number, result));
    }

    public ComplexNumber getResult() {
        return result;
    }

    public void setResult(ComplexNumber result) {
        this.result = result;
    }

    public List<String> getHistory() {
        return history;
    }

    public void calculation(char operator, ComplexNumber number) {
        switch (operator) {
            case '+':
                add(number);
                break;
            case '-':
                subtract(number);
                break;
            case '*':
                multiply(number);
                break;
            case '/':
                divide(number);
                break;
        }
    }
}
