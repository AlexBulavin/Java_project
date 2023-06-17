package Lesson11.Homework.Task4MVPandSOLID;

public class SquareModelImpl implements I_SquareModel {
    @Override
    public double calculateSquare(double side) {
        return side * side;
    }
}
