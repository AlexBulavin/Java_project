package Lesson1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task04_1 {
    public static void main_2(String[] args) {
        String[] expressions = {
                "86? * 32? = 27638?",
                "12? + 4?5 = 558",
                "63? + ?30 = 86?",
                "?2-???=?0"
        };
        String pattern = "(\\d+|\\?+|\\s+)([+\\-*\\/])(\\d+|\\?+|\\s+)(=)(\\d+|\\?+|\\s+)";
        Pattern r = Pattern.compile(pattern);
        for (String expression : expressions) {

            Matcher m = r.matcher(expression);
            if (m.find()) {
                System.out.println("Expression: " + expression);
                System.out.println("Operand 1: " + m.group(1));
                System.out.println("Operator: " + m.group(2));
                System.out.println("Operand 2: " + m.group(3));
                System.out.println("Equals sign: " + m.group(4));
                System.out.println("Result: " + m.group(5));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String[] expressions = {
                "86? * 32? = 27638?",
                "12? + 4?5 = 558",
                "63? + ?30 = 86?",
                "?2-???=?0"
        };
        // String regex = "(\\d*[?]\\d*)\\W+(\\d*[?]\\d*)\\W+=\\W+(\\d*[?]\\d*)";
        // String regex = "(\\d*\\?)?[\\+\\-\\*/=](\\d*\\?)?(\\s)?=(\\s)?(\\d*\\?)?";

        String regex = "(\\s*[0-9?]*\\s*)([+\\-*\\/])(\\s*[0-9?]*\\s*)(=)(\\s*[0-9?]*\\s*)";//"(\\d+|\\?+|\\s+)([+\\-*\\/])(\\d+|\\?+|\\s+)(=)(\\d+|\\?+|\\s+)";//"(\\d+|\\?+|\\s+)([+\\-*\\/])(\\d+|\\?+|\\s+)(=)(\\d+|\\?+|\\s+)";// ("\\s*[\\d?\\s*])([+\\-*\\/]\\s*[\\d?\\s]*)(=)(\\s*[\\d?\\s]*");
                                                                                         // //(\\d*[?]\\d*)\\s*([+\\-*/=])\\s*(\\d*[?]\\d*)\\s*=\\s*(\\d*[?]\\d*)";

        Pattern pattern = Pattern.compile(regex);

        for (String expression : expressions) {
            System.out.println("Parsing expression: " + expression);

            Matcher matcher = pattern.matcher(expression);

            if (matcher.find()) {
                String firstNumber = matcher.group(1);
                String operator = matcher.group(2);// expression.substring(firstNumber.length(), expression.indexOf('=')
                                                   // - 1);
                String secondNumber = matcher.group(3);
                String equasion = matcher.group(4);
                String result = matcher.group(5);

                System.out.println("First number: " + firstNumber);
                System.out.println("Operator: " + operator);
                System.out.println("Second number: " + secondNumber);
                System.out.println("Equasion: " + equasion);
                System.out.println("Result: " + result);
            } else {
                System.out.println("No match found for expression: " + expression);
            }

            System.out.println("-------------------------");
        }
    }
}

/*
 * Здесь в вывод добавлена строка "Operator: " + matcher.group(2)), которая
 * выводит разделитель второй группы. Вот какой вывод должен получиться:
 * 
 * yaml
 * 
 * Matched expression: 86? * 32? = 27638?;
 * First number: 86?
 * Operator: *
 * Second number: 32?
 * Result: 27638?
 * -------------------------
 * Matched expression: 12? + 4?5 = 558;
 * First number: 12?
 * Operator: +
 * Second number: 4?5
 * Result: 558
 * -------------------------
 * Matched expression: 63? + ?30 = 86?;
 * First number: 63?
 * Operator: +
 * Second number: ?30
 * Result: 86?
 * -------------------------
 * Matched expression: ?2-???=?0;
 * First number: ?2-???
 * Operator: -
 * Second number: ???
 * Result: ?0
 * -------------------------
 * 
 */