package Lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class task03 {

    private static final Deque<Double> HISTORY = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4task03Log.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);
        boolean debugMode = false;
        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // Реализовать простой калькулятор
        // И запись двусторонней очереди или стека. Чтобы при вводе пользователем слова
        // Отмена удалялась предыдущая операция
        // Введите первое число: 12
        // Введите операцию: +
        // Введите второе число: 1
        // Ответ: 13
        clearScreen();
        Scanner input = new Scanner(System.in);
        while (true) { // Внешний бесконечный цикл, пока пользователь не введёт q, опрашиваем его
            System.out.print("Введите первое число (или q для выхода): ");
            String inputLine = input.nextLine();
            if (inputLine.equalsIgnoreCase("q")) {
                System.out.println("Вычисления завершены. Данные будут удалены.");
                break;
            }
            double num1 = 0.0;
            try {
                num1 = Double.parseDouble(inputLine);
                // Введенное значение является числом
            } catch (NumberFormatException e) {
                // Введенное значение не является числом
                System.out.println("Введенные значения не являются числом или командой завершения программы.");
            }
            if (debugMode) LOGGER.info("Первое число: " + num1);
            char operator = '\u0000'; // тип char ссылочный, поэтому присваиваем null pointer ссылку
            String operates = "+-*/";
            boolean historyEnabled = false;
            while (true) {
                System.out.print("Введите операцию +, -, *, / (или h для истории операций): ");
                String operatorInput = input.nextLine();
                if (operatorInput.equalsIgnoreCase("h")) {
                    historyEnabled = true;
                    printHistory();
                    continue;
                }
                operator = operatorInput.charAt(0);
                LOGGER.info("Операнд: " + operator);
                if (operates.contains(Character.toString(operator))) {
                    break;
                } else {
                    System.out.printf("Ошибка, введен: %s\n", operator);
                    LOGGER.info("Ошибка, введен: " + operator);
                }
            }
            System.out.print("Введите второе число: ");
            double num2 = input.nextDouble();
            LOGGER.info("Второе число: " + num2);
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Операция неверна.");
                    LOGGER.info("Операция неверна." + operator);
                    return;
            }
            String strResult = result % 1 != 0 ? String.format("%.2f", result) : String.format("%.0f", result);
            System.out.printf("Ответ: %s\n", strResult);
            LOGGER.info("Ответ: \n" + strResult);
            // Добавляем результат в историю
            if (historyEnabled) {
                HISTORY.push(result);
                historyEnabled = false;
            }
            // TODO: Возможно здесь ошибка
            input.nextLine(); // очищаем буфер после ввода числа, чтобы корректно работало ввод следующей
                              // операции
        }
        // --------------- Окончание рабочего кода ----------------------
        // Заканчиваем запись событий
        // recording.interrupt();
        // recording.join();

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
    private static void clearScreen() throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4task03LogclearScreen.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private static void printHistory() {
        System.out.println("История:");
        for (Double result : HISTORY) {
            System.out.println(result);
        }
    }
/*
    private static class Recording extends Thread {
        @Override
        public void run() {
            Logger LOGGER = Logger.getLogger(lesson.class.getName());
            // Создаем файловый обработчик
            FileHandler fileHandler;
            try {
                fileHandler = new FileHandler("Lesson4task03Recording.txt", false);
                // Добавляем обработчик к логгеру
                LOGGER.addHandler(fileHandler);
            } catch (SecurityException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                while (true) {
                    sleep(60000);
                    String logContents = new String(Files.readAllBytes(Paths.get("calculator.log")));
                    LOGGER.info(logContents);
                }
            } catch (IOException | InterruptedException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
*/
}
