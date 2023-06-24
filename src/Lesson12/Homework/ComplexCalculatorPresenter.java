package Lesson12.Homework;
public class ComplexCalculatorPresenter {
    private ComplexCalculatorView view;
    private ComplexCalculatorModel model;

    public ComplexCalculatorPresenter(ComplexCalculatorView view, ComplexCalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void performCalculation() {
        double realPart = view.getInputNumber("вещественную");
        double imaginaryPart = view.getInputNumber("мнимую");
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);
        model.setResult(result);

        char operator = view.getInputOperator();
        String symbols = "+-*/sp";
        while (symbols.indexOf(operator) == -1) {
            System.out.println("Несуществующий оператор, повторите ввод");
            operator = view.getInputOperator();
        }

        if (operator == 's' || operator == 'p') {
            double realNumber = view.getInputNumber("вещественную");
            double imaginaryNumber = view.getInputNumber("мнимую");
            ComplexNumber number = new ComplexNumber(realNumber, imaginaryNumber);
            model.calculation(operator, number);
        } else {
            double realNumber = view.getInputNumber("вещественную");
            double imaginaryNumber = view.getInputNumber("мнимую");
            ComplexNumber number = new ComplexNumber(realNumber, imaginaryNumber);
            model.calculation(operator, number);
        }

        view.displayResult(model.getResult());
        view.displayHistory(model.getHistory());
    }
}


