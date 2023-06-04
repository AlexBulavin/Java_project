package Lesson8.Task5;

public class Program {
    public static void main(String[] args) {
        BinaryOperator_1<Integer> numTest_1 = (x, y) -> (x * y);
        System.out.println(numTest_1.apply(3, 5));
        
        BinaryOperator_1<Integer> numTest_2 = (x, y) -> (x + y);
        System.out.println(numTest_2.apply(4, 6));

        BinaryOperator_1<Double> numTest_3 = (x, y) -> (y / x);
        System.out.println(numTest_3.apply(3.8, 6.2));
    }
}
