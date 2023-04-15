import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        clearScreen();
        System.out.println("Hello, World!");
        InnerApp.main(args);
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!", name);
        System.out.println();
        iScanner.close();
    }
/*
 Метод очистки консоли терминала
 */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

/**
 * InnerApp
 */
public class InnerApp {

    public static void main(String[] args) {
        int a = 123;
a = --a-a--;
System.out.print("a = ");
System.out.println(a);
System.out.println(getType(a));
    }
}
static String getType(Object o) {
    return o.getClass().getSimpleName();
}
}