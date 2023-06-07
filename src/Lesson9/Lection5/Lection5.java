package Lesson9.Lection5;

public class Lection5 {

    public static void main(String[] args) {
        Number num1 = new Number(10.0);
        Number num2 = new Number(5.5);

        Number sum1 = num1.add(num2);
        System.out.println("Сумма: " + sum1.getValue());

        Number sum2 = num1.add(2);
        System.out.println("Сумма: " + sum2.getValue());

        Number sum3 = num2.add(3.3);
        System.out.println("Сумма: " + sum3.getValue());

        int intValue = sum1.toInt();
        System.out.println("Приведение к int: " + intValue);

        float floatValue = sum2.toFloat();
        System.out.println("Приведение к float: " + floatValue);
    }
}


