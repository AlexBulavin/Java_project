package Lesson11.Homework.Task4_2MVPandSOLID;

import java.util.Random;

public class ArrayModelImpl implements I_ArrayModel {
    private Random random;

    public ArrayModelImpl() {
        random = new Random();
    }

    @Override
    public int[] generateRandomNumbers(int size, int minValue, int maxValue) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return numbers;
    }

    @Override
    public String[] generateRandomWords(int size, int wordLength) {
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = generateRandomWord(wordLength);
        }
        return words;
    }

    private String generateRandomWord(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
