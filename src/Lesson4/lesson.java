package Lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class lesson {

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4lessonLog.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);

        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // 1) Замерьте время, за которое в ArrayList добавятся 100000 элементов.
        //2) Замерьте время, за которое в LinkedList добавятся 100000 элементов. Сравните с предыдущим.
        long statTime1 = System.currentTimeMillis();
        ArrayList <Integer> arr = new ArrayList<>();
        // Random rnd = new Random();
        Integer arrSize = 500000;//rnd.nextInt(10, 50);
        
        Double averageValue = 0.0;

        for (int i = 0; i < arrSize; i++) {
            arr.add(0, i);//(rnd.nextInt(50));
            //LOGGER.info("arr[" + i + "] = " + arr.get(i));
            
        }
        long endTime1 = System.currentTimeMillis() - statTime1;
        long statTime2 = System.currentTimeMillis();
        LinkedList <Integer> arr2 = new LinkedList<>();
        for (int i = 0; i < arrSize; i++) {
            arr2.add(0, i);//(rnd.nextInt(50));
            //LOGGER.info("arr[" + i + "] = " + arr.get(i));
            
        }
        long endTime2 = System.currentTimeMillis() - statTime2;
        System.out.println("Время выполнения через ArrayList = " + endTime1);     
        System.out.println("Время выполнения через LinkedList = " + endTime2);
   
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
