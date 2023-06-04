package Lesson9.Seminar;

public class Program {
    public static void main(String[] args) {
        Gen<Integer, String> iOb = new Gen<Integer, String>(88, "Word");
        iOb.showType();
        int v = iOb.getOb();
        String str = iOb.getOb2();

        System.out.println("Значение v = " + v);
        System.out.println("Значение str = " + str);
    }
}
