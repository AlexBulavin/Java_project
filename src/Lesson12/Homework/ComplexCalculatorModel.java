package Lesson12.Homework;

public class ComplexCalculatorModel {
    private ComplexNumber result;

    public void add(ComplexNumber number) {
        double realResult = result.getReal() + number.getReal();
        double complexityResult = result.getComplexity() + number.getComplexity();
        result = new ComplexNumber(realResult, complexityResult);
    }

    public void subtract(ComplexNumber number) {
        double realResult = result.getReal() - number.getReal();
        double complexityResult = result.getComplexity() - number.getComplexity();
        result = new ComplexNumber(realResult, complexityResult);
    }

    public void multiply(ComplexNumber number) {
        double realResult = (result.getReal() * number.getReal()) - (result.getComplexity() * number.getComplexity());
        double complexityResult = (result.getReal() * number.getComplexity()) + (result.getComplexity() * number.getReal());
        result = new ComplexNumber(realResult, complexityResult);
    }

    public void divide(ComplexNumber number) {
        double divisor = (number.getReal() * number.getReal()) + (number.getComplexity() * number.getComplexity());
        if (divisor != 0) {
            double realResult = ((result.getReal() * number.getReal()) + (result.getComplexity() * number.getComplexity())) / divisor;
            double complexityResult = ((result.getComplexity() * number.getReal()) - (result.getReal() * number.getComplexity())) / divisor;
            result = new ComplexNumber(realResult, complexityResult);
        } else {
            throw new IllegalArgumentException("Ошибка: деление на ноль");
        }
    }

    public ComplexNumber getResult() {
        return result;
    }

    public void setResult(ComplexNumber result) {
        this.result = result;
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

