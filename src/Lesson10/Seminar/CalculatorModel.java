package Lesson10.Seminar;

public class CalculatorModel {
    private double result;

    public void add(double number) {
        result += number;
    }

    public void subtract(double number) {
        result -= number;
    }

    public void multiply(double number) {
        result *= number;
    }

    public void divide(double number) {
        CalculatorView localNumber = new CalculatorView();
        while (number == 0){
            System.out.println("Деление на ноль, повторите ввод.");
            number = localNumber.getInputNumber("второе");
        }
            result /= number;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void calculation(char operator, double number_2){
        switch (operator) {
            case '+':
                add(number_2);
                break;
            case '-':
                subtract(number_2);
                break;
            case '*':
                multiply(number_2);
                break;
            case '/':
                divide(number_2);
                break;
        }
    }
}