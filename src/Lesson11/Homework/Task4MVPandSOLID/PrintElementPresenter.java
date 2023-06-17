package Lesson11.Homework.Task4MVPandSOLID;

public class PrintElementPresenter<T> {
    private I_PrintElementView<T> view;

    public PrintElementPresenter(I_PrintElementView<T> view) {
        this.view = view;
    }

    public void printElement(T element) {
        view.displayElement(element);
    }
}
