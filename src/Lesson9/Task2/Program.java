package Lesson9.Task2;

public class Program {
   
    public static void main(String[] args) {
        Numeric<Integer> a = new Numeric<Integer>(5);
        System.out.println("Обратная величина а = 1/а = " + a.dubReturn());
        System.out.println("Дробная часть а = " + a.dubRestReturn());

        Numeric<Double> b = new Numeric<Double>(8.6);
        System.out.println("Обратная величина b = 1/b = " + b.dubReturn());
        System.out.printf("Дробная часть b = %.2f\n", b.dubRestReturn());

        //Numeric<String> c;
    }
    
}
