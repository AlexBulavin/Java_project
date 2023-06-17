package Lesson11.Homework.Task4_2MVPandSOLID;

import Lesson11.Homework.Task4MVPandSOLID.Task1ClearScreen;

public class Task2 {
    public static void main(String[] args) {
        I_ArrayView arrayView = new ConsoleArrayView();
        I_ArrayModel arrayModel = new ArrayModelImpl();
        ArrayPresenter arrayPresenter = new ArrayPresenter(arrayModel, arrayView);

        Task1ClearScreen.clearScreen();
        
        int size = 5;
        int minValue = 1;
        int maxValue = 10;
        arrayPresenter.generateRandomNumbers(size, minValue, maxValue);

        int wordSize = 3;
        int wordLength = 5;
        arrayPresenter.generateRandomWords(wordSize, wordLength);
    }
}
