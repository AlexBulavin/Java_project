package Lesson11.Homework.Task4_2MVPandSOLID;

public class ArrayPresenter {
    private I_ArrayModel model;
    private I_ArrayView view;

    public ArrayPresenter(I_ArrayModel model, I_ArrayView view) {
        this.model = model;
        this.view = view;
    }

    public void generateRandomNumbers(int size, int minValue, int maxValue) {
        int[] numbers = model.generateRandomNumbers(size, minValue, maxValue);
        view.displayNumbers(numbers);
    }

    public void generateRandomWords(int size, int wordLength) {
        String[] words = model.generateRandomWords(size, wordLength);
        view.displayWords(words);
    }
}
