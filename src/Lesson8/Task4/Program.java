package Lesson8.Task4;

import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        Predicate<Integer> isNum = x -> x > 0; 
        System.out.println(isNum.test(5));
        System.out.println(isNum.test(-7));


        Predicate<Double> isNumD = x -> x > 0;
        System.out.println(isNumD.test(5.2));
        System.out.println(isNumD.test(-7.2));
    }
}
