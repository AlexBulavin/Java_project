package Lesson6.Homework_Seminar1.task2;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        System.out.println("Работает конструктор без параметров");
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(double width, double height) {
        System.out.println("Работает конструктор с параметрами");
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
