package Lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class task01 {

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson3task01Log.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);

        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // (Дополнительно) Реализовать алгоритм сортировки слиянием
        // #################################
        ArrayList<Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        Integer arrSize = rnd.nextInt(10, 20);
        // Заполнили массив
        for (int i = 0; i < arrSize; i++) {
            arr.add(rnd.nextInt(50));
            // LOGGER.info("arr[" + i + "] = " + arr.get(i));
        }

        System.out.println("Исходный массив: " + arr);
        mergeSort(arr);
        System.out.println("Отсортированный массив: " + arr);
         // [1, 2, 3, 4, 5, 6]

        // --------------- Окончание рабочего кода ----------------------
        // Останавливаем запись событий
        recording.stop();

        try {
            // Сохраняем записанные события в файл
            Files.createDirectories(Paths.get("profile"));
            recording.dump(Paths.get("profile", "myrecording.jfr"));
        } catch (IOException e) {
            // Читаем записанные события из файла
            try {
                RecordingFile recordingFile = new RecordingFile(Paths.get("profile", "myrecording.jfr"));
                while (recordingFile.hasMoreEvents()) {
                    RecordedEvent event = recordingFile.readEvent();
                    // Обрабатываем записанные события
                    // ...
                }

            } catch (IOException e1) {
                // Обработка исключения
                e1.printStackTrace();
            }
            // Обработка исключения
            e.printStackTrace();
        }
    }

    public static void mergeSort(List<Integer> incomingArr) {
        if (incomingArr.size() > 1) {
            System.out.println("line 76" + incomingArr);
            int mid = incomingArr.size() / 2;
            List<Integer> leftArr = incomingArr.subList( 0, mid);
            List<Integer> rightArr = incomingArr.subList( mid, incomingArr.size());
            mergeSort(leftArr);
            mergeSort(rightArr);
            merge(incomingArr, leftArr, rightArr);
            System.out.println("line 83" + incomingArr);
            System.out.println("line 84" + leftArr);
            System.out.println("line 85" + rightArr);
        }
    }

    private static void merge(List<Integer> arr, List<Integer> leftArr, List<Integer> rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(k, leftArr.get(i));
                i++;
            } else {
                arr.set(k, rightArr.get(i));
                j++;
            }
            k++;
        }
        while (i < leftArr.size()) {
            arr.set(k, leftArr.get(i));
            i++;
            k++;
        }
        while (j < rightArr.size()) {
            arr.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }

    /*
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}