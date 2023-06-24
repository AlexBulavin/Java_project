package Lesson12.Homework;

public class ComplexCalculator {
    public static void main(String[] args) {
        CalculatorView.clearScreen();
        CalculatorView view = new CalculatorView();
        ComplexCalculatorModel model = new ComplexCalculatorModel();
        ComplexCalculatorPresenter presenter = new ComplexCalculatorPresenter(view, model);

        presenter.performCalculation();
    }
}

