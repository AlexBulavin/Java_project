package Lesson9.Task2;

public class Numeric<T extends Number> {
    T num;

    Numeric(T n) {
        num = n;
    }

    double dubReturn() {
        return 1 / num.doubleValue();
    }

    double dubRestReturn() {
        return num.doubleValue() - num.intValue();
    }

    boolean absEqual(Numeric<?> a) {//Используем шаблон аргумента, что позволяет сравнивать объекты произвольных типов
        if (Math.abs(num.doubleValue()) == Math.abs(a.num.doubleValue())) {
            return true;
        } else {
            return false;
        }
    }

}
