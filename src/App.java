import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        clearScreen();
        // System.out.println("Hello, World!");
        // InnerApp.main(args);
        // Scanner iScanner = new Scanner(System.in);
        // System.out.print("name: "); // s: - подсказка от VS Code
        // String name = iScanner.nextLine(); // Забираем строку из терминала ввода
        // System.out.printf("Привет, %s!", name);
        // System.out.println();
        // iScanner.close();
        int [] arr = new int[]{1,1,0,1,1,1};
        int curr_count = 0;
        int max_count = 0;
        for (int i = 0; i < arr.length; i++ ){
            if (arr[i]  == 1) {
                curr_count ++;
            }
            else {
                if (max_count < curr_count){
                    max_count = curr_count;
                }
                curr_count = 0;
            }
        }
        if (max_count < curr_count){
            max_count = curr_count;
        }
        System.out.printf("max_count = %d \n", max_count);

    }

    /*
     * Метод очистки консоли терминала
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
            a = --a - a--;
            System.out.print("a = ");
            System.out.println(a);
            System.out.println(getType(a));
        }
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}