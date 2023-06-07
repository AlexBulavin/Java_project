package Lesson9.Task3;

public class Program {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        Gen<A > g = new Gen<A>(a);
        Gen<B> g2 = new Gen<B>(b);
        Gen<C> g3 = new Gen<C>(c);
        Gen<D> g4 = new Gen<D>(d);

        test(g);
        test(g2);
        test(g3);
        test(g4);
    }

    static void test(Gen<? extends A> o){//В качестве аргумента включены A и все его наследники
        //
    }

    // static void test(Gen<? super C> o){//В качестве аргумента (нижняя граница) включены С и все его предки
    //     //
    // }
}
