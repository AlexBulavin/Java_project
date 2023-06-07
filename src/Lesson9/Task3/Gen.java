package Lesson9.Task3;

public class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    static void test(Gen<? extends A> o){
        //
    }

    static void test2(Gen<? extends D> o){
        //
    }
}
