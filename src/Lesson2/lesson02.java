package Lesson2;
//Class work
public class lesson02 {
    public static void main(String[] args) throws Exception {
        int n = 20;
        String c1 = "a";
        String c2 = "b";
        // extracted(n, c1, c2);
        // arj();
        System.out.println(palindrom("12345g1661g54321"));

    }

    private static void extracted(int n, String c1, String c2) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i <= n / 2; i++) {
            result.append(c1 + c2);
        }
        System.out.printf("%s\n", result.toString());
    }
/*
    private static void arj() {
        StringBuilder start = new StringBuilder("aabbbcddaaa");
        StringBuilder result = new StringBuilder("");
        Integer counter = 1;
        int j = 1;
        // char letter = ;
        for (int i = 0; i < start.length() - 1; i++) {
//Выяснить где проблема!!! - Вылет за размер 
            while (i + counter < start.length() && start.charAt(i) == start.charAt(i + counter) ) {
                counter++;
                j++;
            }
            i += j;
            j = 1;
            if (counter > 1) {
                result.append(start.charAt(i) + counter.toString());
            } else {
                result.append(start.charAt(i));
            }
            counter = 1;
            System.out.printf("%s\n", result.toString());
        }
        System.out.printf("%s\n", result.toString());
    }
    */
    private static boolean palindrom(String word) {
        int i1 = 0;
        int i2 = word.length()-1;
        while(i2 > i1){
            if(word.charAt(i1) != word.charAt(i2)){
                return false;
            }
            i1 ++;
            i2--;
        }
        return true;

    }

}
// clearScreen();
// Random item = new Random();
// int randomNumber = item.nextInt(5, 25);

// /*
// * Метод очистки консоли терминала
// */
// public static void clearScreen() {
// System.out.print("\033[H\033[2J");
// System.out.flush();
// }
