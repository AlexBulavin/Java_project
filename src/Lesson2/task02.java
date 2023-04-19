package Lesson2;

/*
 *     Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода в консоль:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task02 {
    public static void main(String[] args) {
        clearScreen();
        String filePath = "src/Lesson2/evaluation_list.txt"; // замените на путь к вашему файлу
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            parserAndBuilder(br);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    /*
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void parserAndBuilder(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("[,:]"); // разбиваем строку по запятым и двоеточиям
            String surname = parts[1].replace("\"", "");
            String mark = parts[3].replace("\"", "");
            String subject = parts[5].replace("\"", "");
            StringBuilder sb = new StringBuilder();
            sb.append("Студент " + surname + " получил " + mark + " по предмету " + subject + ".");
            System.out.println(sb);
        }
    }
}
