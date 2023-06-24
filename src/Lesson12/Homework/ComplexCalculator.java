package Lesson12.Homework;

public class ComplexCalculator {
    public static void main(String[] args) {
        ComplexCalculatorView.clearScreen();
        ComplexCalculatorView view = new ComplexCalculatorView();
        ComplexCalculatorModel model = new ComplexCalculatorModel();
        ComplexCalculatorPresenter presenter = new ComplexCalculatorPresenter(view, model);

        presenter.performCalculation();
    }
}


