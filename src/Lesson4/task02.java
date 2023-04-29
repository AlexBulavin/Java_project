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
import Lesson4.CustomQueue;
import Lesson4.task01;//task01.fillInRandomIntInRange;

public class task02 {

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4task02Log.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);
        boolean debugMode = true; //false; //Задали режим отладки. В нём будут писаться и авводиться логи. Иначе -
        // не будут.

        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        /*
         * 2) Реализуйте очередь с помощью LinkedList со следующими методами:
         * enqueue() - помещает элемент в конец очереди,
         * dequeue() - возвращает первый элемент из очереди и удаляет его,
         * first() - возвращает первый элемент из очереди, не удаляя.
         * 
         * Пример:
         * [1, 2, 3, 4, 5, 6, 7]
         * spisok.enqueue(8)
         * [1, 2, 3, 4, 5, 6, 7,8]
         * spisok.dequeue
         * 1
         * [2, 3, 4, 5, 6, 7,8]
         * spisok.first()
         * 2
         * [2, 3, 4, 5, 6, 7,8]
         * 
         */

        Random rnd = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        // Создаём экземпляр LinkedList и заполняем его случайными числами в диапазоне
        // minLen, maxLen
        int minLen, maxLen, minItem, maxItem;
        // Задаём границы длины LinkedList. Можно это сделать хардкодом, можно попросить
        // пользователя ввести данные, можно рндомайзером и так далее
        minLen = 5;
        maxLen = 15;
        minItem = 5;
        maxItem = 95;
        int lengthLinkedList = rnd.nextInt(minLen, maxLen);
        if (debugMode)
            LOGGER.info("lengthLinkedList = " + lengthLinkedList);
        Lesson4.task01 task01 = new task01();
        task01.fillInRandomIntInRange(LOGGER, debugMode, rnd, linkedList, minItem, maxItem, lengthLinkedList);

        System.out.println("LinkedList со случайными элементами:");
        System.out.println(linkedList);

        //В классе CustomQueue реализовали нужные по Д/З методы, создаём экземпляр класса ниже вызываем его методы и проверяем.
        Lesson4.CustomQueue customQueue = new CustomQueue(LOGGER, debugMode, linkedList);
        int itemToPutIn = 8; //Произвольное число типа int, которое мы добавляем в очередь
        customQueue.enqueue(8);
        System.out.println("customQueue.enqueue(" + 8 +"):");
        System.out.println(linkedList);

        customQueue.dequeue();
        System.out.println("customQueue.dequeue()");
        System.out.println(linkedList);

        customQueue.first();
        System.out.println("customQueue.first()");
        System.out.println(linkedList);
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

    /*
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
