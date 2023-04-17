package Lesson1;

// import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
// import jdk.jfr.FlightRecorder;
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

        // Решать нужно подстановкой
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение вида q?qq?? + ww?www?? = e?e, где q, w, e >= 0: ");
        String input = scanner.nextLine();

        String regex = "(\\s*[0-9?]*\\s*)([+\\-*\\/])(\\s*[0-9?]*\\s*)(=)(\\s*[0-9?]*\\s*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String q = "";
        String w = "";
        String e = "";
        Character operator = null;

        if (matcher.find()) {
            q =  matcher.group(1); 
            w =  matcher.group(3); 
            e =  matcher.group(5); 
            operator = matcher.group(2).charAt(0);
            for (Integer i = 0; i < 10; i++) {
                String operand1 = q.replace("?", i.toString());
                String operand2 = w.replace("?", i.toString());
                String operand3 = e.replace("?", i.toString());
                operand1 = operand1.replace(" ", "");
                operand2 = operand2.replace(" ", "");
                operand3 = operand3.replace(" ", "");

                // --------Логика проверки здесь--------
                Integer calculatedResult = 0;
                Integer equasion = Integer.parseInt(operand3);
                //Проверочные примеры: 86? * 32? = 27638?  12? + 4?5 = 558 63? + ?30 = 86? ?2?-???=?0
                // System.out.printf("equasion = %s\n", equasion);
                // System.out.printf("%s %s %s = %s\n", operand1, operator, operand2, operand3);
                Boolean trigger = false;
                //System.out.printf("Line 58 operator.toString() = %s\n",operator.toString());
                switch (operator.toString()) {
                    case "+":
                        calculatedResult = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                        trigger = true;
                        break;
                    case "-":
                        calculatedResult = Integer.parseInt(operand1) - Integer.parseInt(operand2);
                        trigger = true;
                        break;
                    case "*":
                        calculatedResult = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                        trigger = true;
                        break;
                    case "/":
                        calculatedResult = Integer.parseInt(operand1) / Integer.parseInt(operand2);
                        trigger = true;
                        break;
                }
                if (((calculatedResult - equasion) == 0) && trigger) {
                    System.out.println("Найдено значение для формулы:");
                    System.out.printf("%s %s %s = %s\n", operand1, operator, operand2, equasion);  
                }
                trigger = false;
            }

        } else {
            System.out.println("Выражение не соответствует формату.");
            return;
        }
        // --------------- Окончание рабочего кода ----------------------
        // Останавливаем запись событий
        recording.stop();

        try {
            // Сохраняем записанные события в файл
            Files.createDirectories(Paths.get("profile"));
            recording.dump(Paths.get("profile", "myrecording.jfr"));
        } catch (IOException er) {
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
            er.printStackTrace();
        }
    } /*
       * Метод очистки консоли терминала
       */

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
