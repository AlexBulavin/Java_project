package Lesson11.Homework.Task4MVPandSOLID;

public class PrintElementConsoleView<T> implements I_PrintElementView<T> {
    @Override
    public void displayElement(T element) {
        System.out.println(element);
    }
}

