package Lesson1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.  Предложить хотя бы одно решение или сообщить, что его нет. Под знаками вопросов - одна и та же цифра  Ввод: 2? + ?5 = 69 Вывод: 24 + 45 = 69 Проверочные примеры: 86? * 32? = 27638? 12? + 4?5 = 558 63? + ?30 = 86? ?2?-???=?0
//Решение сделано в самом общем случае - размер чисел, количество вопросов в них, пробелы со всех сторон могут быть сколь угодно
//большими (до переполнения типа данных).
// Для проверки добавлены предустановленные примеры в строке 30 - 33. Можно их закомментить, тогда будет обрабатывться только
//Пользовательское уравнение
public class task04 {
    public static void main(String[] args) {
        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // Проверочные примеры: 86? * 32? = 27638? 12? + 4?5 = 558 63? + ?30 = 86? ?2?-???=?0
        // ?2?-???=?0
        String[] expressions = { //Проверочный массив для разных вариантов ввода, операторов и знаков ? внутри числа.
                "86? * 32? = 27638?",
                "12? + 4?5 = 558",
                "63? + ?30 = 86?",
                "?2-???=?0"
        };
        // Создаем новый массив на 1 элемент больше, чем исходный массив
        String[] newExpressions = new String[expressions.length + 1];

        // Копируем все элементы из исходного массива в новый массив
        System.arraycopy(expressions, 0, newExpressions, 0, expressions.length);
        // Решать нужно подстановкой
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение вида q?qq?? + ww?www?? = e?e, где q, w, e >= 0: ");
        String input = scanner.nextLine();
        // Добавляем пользовательский элемент в конец нового массива
        newExpressions[newExpressions.length - 1] = input;
        for (int i = 0; i < newExpressions.length; i++) {
            System.out.println(newExpressions[i]);
        }
       
        String regex = "(\\s*[0-9?]*\\s*)([+\\-*\\/])(\\s*[0-9?]*\\s*)(=)(\\s*[0-9?]*\\s*)";
        Pattern pattern = Pattern.compile(regex);
        
        String q = "";
        String w = "";
        String e = "";
        Character operator = null;
        for (String newExpression : newExpressions) {
            Matcher matcher = pattern.matcher(newExpression);
            if (matcher.find()) {
                q = matcher.group(1);
                w = matcher.group(3);
                e = matcher.group(5);
                operator = matcher.group(2).charAt(0);
                for (Integer i = 0; i < 10; i++) {
                    String operand1 = q.replace("?", i.toString());//Подставляем проверочные цифры на место ?
                    String operand2 = w.replace("?", i.toString());
                    String operand3 = e.replace("?", i.toString());
                    operand1 = operand1.replace(" ", "");//Удаляем лишние пробелы
                    operand2 = operand2.replace(" ", "");
                    operand3 = operand3.replace(" ", "");

                    // --------Логика проверки здесь--------
                    Integer calculatedResult = 0;
                    Integer equasion = Integer.parseInt(operand3);

                    Boolean trigger = false;
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
                        System.out.printf("Найдено значение для формулы: \n%s\n", newExpression);
                        System.out.printf("%s %s %s = %s\n", operand1, operator, operand2, equasion);
                    }
                    trigger = false;
                }

            } else {
                System.out.println("Выражение не соответствует формату.");
                return;
            }
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
