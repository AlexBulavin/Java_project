package Lesson2;

//Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
//результат после каждой итерации запишите в лог-файл.
import java.util.Arrays;
import java.util.logging.*;

public class task01 {

    private static final Logger LOGGER = Logger.getLogger(task01.class.getName());

    public static void main(String[] args)throws Exception {
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("log.txt");
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);
        int[] arr = { 5, 3, 8, 6, 7, 2, 1, 0, 0, 9, 15 };
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        LOGGER.info("Исходный массив: " + Arrays.toString(arr));
        bubbleSort(arr);
        LOGGER.info("Отсортированный массив: " + Arrays.toString(arr));
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            LOGGER.info("After iteration " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapped) {
                break;
            }
        }
    }
}
