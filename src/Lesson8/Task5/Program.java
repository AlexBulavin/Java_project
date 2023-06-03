package Lesson8.Task5;

public class Program {
    public static void main(String[] args) {
        BinaryOperator_1<Integer> numTest_1 = (x, y) -> (x * y);

        System.out.println(numTest_1.apply(3, 5));
        
    }
}
