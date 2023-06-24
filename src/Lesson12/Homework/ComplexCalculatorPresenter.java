package Lesson12.Homework;

import java.util.List;

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

        String operator = view.getInputOperator();
        String symbols = "+-*/sqrt^";
        while (symbols.indexOf(operator) == -1) {
            System.out.println("Несуществующий оператор, повторите ввод");
            operator = view.getInputOperator();
        }

        double realNumber = view.getInputNumber("вещественную");
        double imaginaryNumber = view.getInputNumber("мнимую");
        ComplexNumber number = new ComplexNumber(realNumber, imaginaryNumber);

        if (operator.equals("sqrt") || operator.equals("^")) {
            model.calculation(operator.charAt(0), number);
        } else {
            model.calculation(operator.charAt(0), number);
        }

        view.displayResult(model.getResult());

        List<String> history = model.getHistory();
        view.displayHistory(history);
    }
}

}




