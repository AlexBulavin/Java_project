package Lesson9.Task2;

public class Program {
   
    public static void main(String[] args) {
        Numeric<Integer> a = new Numeric<Integer>(5);
        System.out.println("Обратная величина а = 1/а = " + a.dubReturn());
        System.out.println("Дробная часть а = " + a.dubRestReturn());

        Numeric<Double> b = new Numeric<Double>(8.6);
        System.out.println("Обратная величина b = 1/b = " + b.dubReturn());
        System.out.printf("Дробная часть b = %.2f\n", b.dubRestReturn());

        Numeric<Float> c = new Numeric<Float>(1.25f);
        Numeric<Double> d = new Numeric<Double>(-1.25);
        Numeric<Integer> e = new Numeric<Integer>(-5);
        Numeric<Long> f = new Numeric<Long>(-5L);

        if(d.absEqual(c)){
            System.out.println("Абсолютные значения совпадают");
        }
        else System.out.println("Абсолютные значения не совпадают");

        // if(e.absEqual(f)){
        //     System.out.println("Абсолютные значения совпадают");
        // }
        // else System.out.println("Абсолютные значения не совпадают");

        System.out.println("Абсолютные значения " + (e.absEqual(f)?"":"не") + " совпадают");
    }
    

}
