package Lesson11.Homework.Task4MVPandSOLID;

public class Task1 {
    public static void main(String[] args) {
        I_PrintElementView<Double> squareView = new PrintElementConsoleView<>();
        PrintElementPresenter<Double> squarePresenter = new PrintElementPresenter<>(squareView);
        I_SquareModel squareModel = new SquareModelImpl();

        double side = 5.0;
        double square = squareModel.calculateSquare(side);
        squarePresenter.printElement(square);

        I_PrintElementView<Integer> integerView = new PrintElementConsoleView<>();
        PrintElementPresenter<Integer> integerPresenter = new PrintElementPresenter<>(integerView);

        integerPresenter.printElement(10);

        I_PrintElementView<String> stringView = new PrintElementConsoleView<>();
        PrintElementPresenter<String> stringPresenter = new PrintElementPresenter<>(stringView);

        stringPresenter.printElement("Hello, world!");

        I_PrintElementView<Double> doubleView = new PrintElementConsoleView<>();
        PrintElementPresenter<Double> doublePresenter = new PrintElementPresenter<>(doubleView);

        doublePresenter.printElement(3.14);
    }
}