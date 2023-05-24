package Lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        // Cat barsic = new Cat;
        // barsic.name = "KOT";
        // barsic.age = "12";
        ArrayList <CatExample> kototeka = new ArrayList<>();
        CatExample barsic  = new CatExample("Barsik", 3, "saf");
        CatExample cat2  = new CatExample("Barsik2", 4);
        kototeka.add(cat2);
        kototeka.add(barsic);
        System.out.println(kototeka);
        // for (Cat cats : kototeka) {
        //     cats.print_visit()
        // }
        // cat2.visit()
        // cat2.print_visit()
        barsic.golos();
    }
}
