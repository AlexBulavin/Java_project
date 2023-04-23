package Lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class task01 {

    public static void main(String[] args) throws Exception {
        Logger LOGGER = Logger.getLogger(lesson.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson3lessonLog.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);

        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        // --------------- Начало рабочего кода ----------------------
        clearScreen();
        // (Дополнительно) Реализовать алгоритм сортировки слиянием #################################


        // Заполнить список десятью случайными числами. Отсортировать список методом
        // sort() и вывести его на экран.
        ArrayList arr = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            arr.add(rnd.nextInt(10));
        }
        System.out.println("arr unsorted: \t" + arr);
        arr.sort(null);
        System.out.println("arr sorted: \t" + arr);

        // Заполнить список названиями планет Солнечной системы в произвольном порядке с
        // повторениями.
        // Вывести название каждой планеты и количество его повторений в списке.

        // земля, юпитер, Сатурн, земля, марс, земля, юпитер
        // земля 3
        // юпитер 2
        // Сатурн 1
        // марс 1
        ArrayList <String> plannets = new ArrayList<>(
                Arrays.asList("земля", "юпитер", "Сатурн", "земля", "марс", "земля", "юпитер"));
        ArrayList plannetsSorted = new ArrayList<>();
        for (int i = 0; i < plannets.size() - 1; i++) {
            arr.add(rnd.nextInt(10));
        }
        System.out.println("plannets unsorted: \t" + plannets);

        int counter = 1;
        // Сортируем массив матёрым способом
        for (int i = 0; i < plannets.size(); i++) {
            for (int j = i + 1; j < plannets.size(); j++) {
                if (plannets.get(i).equals(plannets.get(j))) {
                    counter++;
                    plannets.remove(j);
                    j--;
                }
            }
            plannetsSorted.add(counter);
            counter = 1;
        }
        System.out.println("plannets sorted:");
        for (int i = 0; i < plannets.size(); i++) {
            System.out.printf(plannets.get(i) + " - " + plannetsSorted.get(i) + "\n");
        }
/*
 * import java.io.Console;
import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Random;

// Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
// Вывести название каждой планеты и количество его повторений в списке.
public class l3t2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        final int n = 10;
        String[] planets = {"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун"};
        Random rnd = new Random();
        ArrayList<String> plntList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plntList.add(planets[rnd.nextInt(planets.length)]);
        }
       System.out.println(plntList);

        // long time = System.nanoTime();
        int count = 0;
        for (String elem : planets) {
            for (String elem2 : plntList) {
                if (elem.equals(elem2)) count++;
            }
            if (count != 0)
            System.out.printf("%s: %d \n", elem, count);
            count = 0;
        }
        // time = System.nanoTime() - time;
        // System.out.printf("Elapsed %,9.3f ms\n", time / 1_000_000.0);
       
        // long time1 = System.nanoTime();
        // int count1 = 1;
        // plntList.sort(null);
        // for (int i = 1; i < plntList.size(); i++) {
        //     if (plntList.get(i).equals(plntList.get(i-1))) {
        //         count1++;
        //     }
        //     else {
        //         System.out.printf("%s: %d \n", plntList.get(i-1), count1);
        //         count1 = 1;
        //     }
        // }
        // System.out.printf("%s: %d \n", plntList.get(plntList.size()-1), count1);
        // time1 = System.nanoTime() - time1;
        // System.out.printf("Elapsed %,9.3f ms\n", time1 / 1_000_000.0);
        
    }
}
 */

// Создать ArrayList. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
// Можно использовать Collections.frequency(спис, эл)
        ArrayList items = new ArrayList<>(
                Arrays.asList("земля", 1, "юпитер", 5, ">", 2/5, "Сатурн", "земля", "марс", 8, 10, "земля", "юпитер"));
        System.out.println("ArrayList dirt: \t" + items);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Integer){
                items.remove(i);
                i--;
            }
        } 
        System.out.println("ArrayList clean: \t" + items);

        
        // Scanner input = new Scanner(System.in);
        // System.out.print("Введите первое число: ");
        // double num1 = input.nextDouble();
        // LOGGER.info("Первое число: " + num1);
        // char operator = '\u0000'; // тип char ссылочный, поэтому присваиваем null
        // pointer ссылку
        // String operates = "+-*/";
        // while (true) {
        // System.out.print("Введите операцию +, -, *, /: ");
        // operator = input.next().charAt(0);
        // LOGGER.info("операнд: " + operator);
        // if (operates.contains(Character.toString(operator))) {
        // break;
        // } else {
        // System.out.printf("Ошибка, введен: %s\n", operator);
        // LOGGER.info("Ошибка, введен: " + operator);
        // }
        // }
        // System.out.print("Введите второе число: ");
        // double num2 = input.nextDouble();
        // LOGGER.info("Второе число: " + num2);
        // double result = 0;
        // switch (operator) {
        // case '+':
        // result = num1 + num2;
        // break;
        // case '-':
        // result = num1 - num2;
        // break;
        // case '*':
        // result = num1 * num2;
        // break;
        // case '/':
        // result = num1 / num2;
        // break;
        // default:
        // System.out.println("Операция неверна.");
        // LOGGER.info("Операция неверна." + operator);
        // return;
        // }
        // String strResult = result % 1 != 0 ? String.format("%.2f", result) :
        // String.format("%.0f", result);
        // System.out.printf("Ответ: %s\n", strResult);
        // LOGGER.info("Ответ: \n" + strResult);
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
