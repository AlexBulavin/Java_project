package Lesson12.Homework;

public class ComplexCalculatorPresenter {
    private CalculatorView view;
    private ComplexCalculatorModel model;

    public ComplexCalculatorPresenter(CalculatorView view, ComplexCalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void performCalculation() {
        double realPart = view.getInputNumber("вещественную");
        double imaginaryPart = view.getInputNumber("мнимую");
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);
        model.setResult(result);

        char operator = view.getInputOperator();
        String symbols = "+-*/";
        while (symbols.indexOf(operator) == -1) {
            System.out.println("Несуществующий оператор, повторите ввод");
            operator = view.getInputOperator();
        }

        double realNumber = view.getInputNumber("вещественную");
        double imaginaryNumber = view.getInputNumber("мнимую");
        ComplexNumber number = new ComplexNumber(realNumber, imaginaryNumber);
        model.calculation(operator, number);
        view.displayResult(model.getResult());
    }
}

