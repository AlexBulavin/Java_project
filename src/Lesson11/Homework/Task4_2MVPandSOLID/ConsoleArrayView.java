package Lesson11.Homework.Task4_2MVPandSOLID;

public class ConsoleArrayView implements I_ArrayView {
    @Override
    public void displayNumbers(int[] numbers) {
        System.out.print("Random numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    @Override
    public void displayWords(String[] words) {
        System.out.print("Random words: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
