package Lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.*;

public class task01 {

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4task01Log.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);

        boolean debugMode = false; // true; //Задали режим отладки. В нём будут писаться и авводиться логи. Иначе -
                                   // не будут.

        // Начинаем запись событий

        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void),
        // который вернет “перевернутый” список.

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

        fillInRandomIntInRange(LOGGER, debugMode, rnd, linkedList, minItem, maxItem, lengthLinkedList);

        System.out.println("LinkedList со случайными элементами:");
        System.out.println(linkedList);
        // Создаем перевернутый список и заполняем его элементами первого списка,
        // "перевёрнутые" методом Collections.reverse
        // LinkedList<Integer> reversedLinkedList = reverseLinkedList(linkedList, LOGGER, debugMode);
        System.out.println("Перевернутый LinkedList:");
        System.out.println(reverseLinkedList(linkedList, LOGGER, debugMode));

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

    public static void fillInRandomIntInRange(Logger LOGGER, boolean debugMode, Random rnd,
            LinkedList<Integer> linkedList,
            int minItem, int maxItem, int lengthLinkedList) {
        for (int i = 0; i < lengthLinkedList; i++) {
            int item = rnd.nextInt(maxItem) + minItem; // случайный элемент в диапазоне minItem - maxItem;
            linkedList.add(item);
            if (debugMode)
                LOGGER.info(" new LinkedList item = " + item);
        }
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list, Logger LOGGER, boolean debugMode) {
        LinkedList<Integer> reversedList = new LinkedList<>(list);
        Collections.reverse(reversedList);
        if (debugMode)
            LOGGER.info("reversedList = " + reversedList);
        return reversedList;
    }

    /*
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
