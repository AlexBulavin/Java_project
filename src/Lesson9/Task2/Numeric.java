package Lesson9.Task2;

public class Numeric <T extends Number> {
    T num;
    Numeric (T n){
        num = n;
    }

    double dubReturn(){
        return 1 / num.doubleValue();
    }

    double dubRestReturn(){
        return num.doubleValue() - num.intValue();
    }

    
}
