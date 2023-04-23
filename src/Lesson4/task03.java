package Lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class task03 {

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4task03Log.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);

        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

        ArrayList <Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        Integer arrSize = rnd.nextInt(10, 50);
        
        Double averageValue = 0.0;
        for (int i = 0; i < arrSize; i++) {
            arr.add(rnd.nextInt(50));
            LOGGER.info("arr[" + i + "] = " + arr.get(i));
            averageValue += arr.get(i);
        }
        averageValue = averageValue / arrSize;
        System.out.println("Base arr:\t\t" + arr);     
        System.out.println("min of arr =\t\t" + Collections.min(arr));
        System.out.println("max of arr =\t\t" + Collections.max(arr));
        System.out.println("average of arr =\t" + averageValue);
   
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

    private static void min(ArrayList<Integer> arr) {
    }

    /*
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
