import java.util.Random;
// import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        clearScreen();

        Random item = new Random();

        int[] arr = new int[item.nextInt(20, 30)];// {1,0,1,0,0,1,1};
        int arrVal = arr.length;
        System.out.print("arr = ");
        for (int i = 0; i < arrVal; i++) {
            arr[i] = item.nextInt(2, 5);
            System.out.printf("%d  ", arr[i]);
        }
        System.out.println("\nМассив заполнен");
        int val = 3;
        int count = 0;
        for (int i = 0; i < arrVal; i++) {
            if (arr[i] != val) {

                arr[count++] = arr[i];

            }
        }
        while (count < arrVal)
            arr[count++] = val;

        System.out.println("\nМассив отсортирован");
        for (int i = 0; i < arrVal; i++) {
            System.out.printf("%d  ", arr[i]);
        }
        System.out.println();

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

/*public class Main {
    public static void main(String[] args) {
        int [] arr = new int[]{1,3,3,2,4,3,5,3,3}; //1 2 4 5 3,3,3,3,3
        int val = 3;
        int count = 0;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] != val) {
                arr[count++] = arr[i];
            }
        while (count < arr.length)
            arr[count++] = val;
        for (int i : arr) {
            System.out.println(i);
        }
    }
    
}*/