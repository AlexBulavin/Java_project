package Lesson1;

import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.FlightRecorder;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком 
//вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
//Предложить хотя бы одно решение или сообщить, что его нет. Под знаками вопросов - одна и та же цифра 
//Ввод: 2? + ?5 = 69 Вывод: 24 + 45 = 69
public class task04 {
    public static void main(String[] args) {
        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();

        // String regex = "(\\d*\\?{0,1}) ([\\+\\-\\*/]) (\\d*\\?{0,1}) =
        // (\\d*\\?{0,1})";
        //Решать нужно подстановкой
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение вида q?qq?? + ww?www?? = e?e, где q, w, e >= 0: ");
        String input = scanner.nextLine();

        String regex = "(\\d*\\?{0,1}) ([\\+\\-\\*/]) (\\d*\\?{0,1}) = (\\d*\\?{0,1})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String q = matcher.group(1).equals("") ? "0" : matcher.group(1);
            String w = matcher.group(3).equals("") ? "0" : matcher.group(3);
            String e = matcher.group(4).equals("") ? "0" : matcher.group(4);
            char operator = matcher.group(2).charAt(0);

            System.out.printf("q = %s, w = %s, e = %s, operator = %c%n", q, w, e, operator);
        } else {
            System.out.println("Выражение не соответствует формату.");
        }
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
