package Lesson9.Seminar;

public class Gen <Metro, Retro> {
    Metro ob;//Объявить объект типа Metro
    Retro ob2;//Объявить объект типа Retro
    Gen (Metro o, Retro o2){
        ob = o;
        ob2 = o2;
    }

    Metro getOb(){
        return ob;
    }
    Retro getOb2(){
        return ob2;
    }

    void showType(){
        System.out.println("Тип Metro - это " + ob.getClass().getName());
        System.out.println("Тип Retro - это " + ob2.getClass().getName());
    
    }
}
