package Lesson10.Seminar;

public class Calc {
    public static void main(String[] args) {
        CalculatorView.clearScreen();
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorPresenter presenter = new CalculatorPresenter(view, model);

        presenter.performCalculation();
    }
}
