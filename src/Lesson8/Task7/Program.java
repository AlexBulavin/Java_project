package Lesson8.Task7;

public class Program {
    public static void main(String[] args) {
        Function_1<Integer, String> test1 = x -> String.valueOf(x) + " $ _____";
        System.out.println(test1.apply(10)); 
    }
}
