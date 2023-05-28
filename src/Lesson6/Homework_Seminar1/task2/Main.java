package Lesson6.Homework_Seminar1.task2;

public class Main {
    public static void main(String[] args) {
        Lesson6.task1.clearScreen();

        Rectangle rectangle1 = new Rectangle();// Здесь вызываем конструктор без параметров
        rectangle1.setWidth(5);
        rectangle1.setHeight(3);

        System.out.println("Площадь прямоугольника: " + rectangle1.calculateArea());
        System.out.println("Периметр прямоугольника: " + rectangle1.calculatePerimeter());
        System.out.println();

        Rectangle rectangle2 = new Rectangle(7, 4);// Здесь вызываем конструктор с параметрами
        System.out.println("Площадь прямоугольника: " + rectangle2.calculateArea());
        System.out.println("Периметр прямоугольника: " + rectangle2.calculatePerimeter());
        System.out.println();
    }
}
