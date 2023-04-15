//1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! 
//(произведение чисел от 1 до n)
package Lesson1;

// import java.util.Scanner;
import java.util.Random;

public class task01 {
    public static void main(String[] args) throws Exception {
        clearScreen();
        Random item = new Random();
        int randomNumber = item.nextInt(200, 500);

        System.out.printf("Случайное число - %d, сумма 1 - n = %d\n", randomNumber, randomNumber*(randomNumber+1)/2);

    }
    public static void factorial() { //Реализовать рекурсией
        
        return 
    }

    /*
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
