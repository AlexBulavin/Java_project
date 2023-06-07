package Lesson9.Lection5;

public class Number {
    protected double value;

    public Number(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Number add(Number other) {
        return new Number(this.value + other.value);
    }

    // Перегрузка оператора "+" для сложения двух чисел разного типа
    public Number add(int other) {
        return new Number(this.value + other);
    }

    public Number add(float other) {
        return new Number(this.value + other);
    }

    public Number add(double other) {
        return new Number(this.value + other);
    }

    // Приведение типов
    public int toInt() {
        return (int) value;
    }

    public float toFloat() {
        return (float) value;
    }

}
