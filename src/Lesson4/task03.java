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
        clearScreen(debugMode);
        // Реализовать простой калькулятор
        // И запись двусторонней очереди или стека. Чтобы при вводе пользователем слова
        // Отмена удалялась предыдущая операция
        // Введите первое число: 12
        // Введите операцию: +
        // Введите второе число: 1
        // Ответ: 13
        Scanner input = new Scanner(System.in);
        double num1 = 0.0;
        while (true) { // Внешний бесконечный цикл, пока пользователь не введёт q, опрашиваем его
            String inputLine = firstNumInput(input);
            if (inputLine.equalsIgnoreCase("q")) {
                System.out.println("Вычисления завершены. Данные будут удалены.");
                break;
            }
            if (inputLine.equalsIgnoreCase("m")) {
                if (!HISTORY.isEmpty()) {
                    num1 = HISTORY.pollLast();
                    System.out.println("Первое число  = " + num1);
                } else {
                    System.out.println("Нет сохранённых данных.\nПервое число  = " + num1);
                }
            } else {
                try {
                    num1 = Double.parseDouble(inputLine);
                    // Введенное значение является числом
                } catch (NumberFormatException e) {
                    // Введенное значение не является числом
                    System.out.println("Введенные значения не являются числом или командой завершения программы.");
                }
            }

            if (debugMode)
                LOGGER.info("Первое число: " + num1);
            char operator = '\u0000'; // тип char ссылочный, поэтому присваиваем null pointer ссылку
            String operates = "+-*/u";
            boolean historyEnabled = false;
            while (true) {
                System.out.print(
                        "Введите операцию +, -, *, / (или u для извлечения последнего значения из истории операций): ");
                String operatorInput = input.nextLine();
                if (operatorInput.equalsIgnoreCase("u")) {
                    if (!HISTORY.isEmpty()) {
                        printHistory();
                        num1 = HISTORY.pollLast();
                        System.out.println("Первое число = " + num1);
                    } else {
                        System.out.println("Нет предыдущего значения в памяти.\nПервое число =  " + num1);
                    }
                    continue;
                }
                operator = operatorInput.charAt(0);
                if (debugMode)
                    LOGGER.info("Операнд: " + operator);
                if (operates.contains(Character.toString(operator))) {
                    break;
                } else {
                    System.out.printf("Ошибка, введен: %s\n", operator);
                    if (debugMode)
                        LOGGER.info("Ошибка, введен: " + operator);
                }
            }
            System.out.print("Введите второе число: ");
            double num2 = input.nextDouble();
            if (debugMode)
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Деление на 0.\nВторое число = 1");
                        result = num1;
                    }
                    break;
                default:
                    System.out.println("Операция неверна.");
                    if (debugMode)
                        LOGGER.info("Операция неверна." + operator);
                    return;
            }
            String strResult = result % 1 != 0 ? String.format("%.2f", result) : String.format("%.0f", result);
            System.out.printf("Ответ: %s\n", strResult);
            if (debugMode)
                LOGGER.info("Ответ: \n" + strResult);
            // Добавляем результат в историю
            HISTORY.addLast(result);
            historyEnabled = true;

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

    private static String firstNumInput(Scanner input) {
        System.out.print("Введите первое число или m для извлечения сохранённого значения или q для выхода: ");
        String inputLine = input.nextLine();
        return inputLine;
    }

    /*
     * Метод очистки консоли терминала
     */
    private static void clearScreen(boolean debugMode) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson4task03LogclearScreen.txt", false);
        // Добавляем обработчик к логгеру
        if (debugMode)
            LOGGER.addHandler(fileHandler);
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            if (debugMode)
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
     * private static class Recording extends Thread {
     * 
     * @Override
     * public void run() {
     * Logger LOGGER = Logger.getLogger(lesson.class.getName());
     * // Создаем файловый обработчик
     * FileHandler fileHandler;
     * try {
     * fileHandler = new FileHandler("Lesson4task03Recording.txt", false);
     * // Добавляем обработчик к логгеру
     * LOGGER.addHandler(fileHandler);
     * } catch (SecurityException | IOException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * try {
     * while (true) {
     * sleep(60000);
     * String logContents = new
     * String(Files.readAllBytes(Paths.get("calculator.log")));
     * LOGGER.info(logContents);
     * }
     * } catch (IOException | InterruptedException ex) {
     * LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
     * }
     * }
     * }
     */
}
