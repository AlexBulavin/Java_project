package Lesson10.Seminar;

public class CalculatorPresenter {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorPresenter(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void performCalculation() {
        model.setResult(view.getInputNumber("первое")); 
        char operator = view.getInputOperator();
        String symbols = "+-*/";
        while (symbols.indexOf(operator) == -1) {
            System.out.println("Несуществующий оператор, повторите ввод");
            operator = view.getInputOperator();
        }  
        Double zero = view.getInputNumber("второе");
        while (operator == '/' && zero == 0.0){
            System.out.println("Деление на ноль, повторите ввод.");
            zero = view.getInputNumber("второе");
        }
        model.calculation(operator, zero);
        view.displayResult(model.getResult());
    }

    // private void calculation(char operator, double number_2){
    //     switch (operator) {
    //         case '+':
    //             model.add(number_2);
    //             break;
    //         case '-':
    //             model.subtract(number_2);
    //             break;
    //         case '*':
    //             model.multiply(number_2);
    //             break;
    //         case '/':
    //             model.divide(number_2);
    //             break;
    //     }
    // }
}