package Lesson5;

import java.time.LocalDate;
import java.util.HashMap;

public class Cat {
    Integer birthyear;
    String name;
    boolean gender;
    String vendor_phone;

    HashMap<String, String>visits = new HashMap<>();//Журнал посещений
//Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, 
// которое является информационной системой ветеринарной клиники

// Поля:
// integer age - возраст
// string name - имя
// boolean

// Методы:
// miay - кот "name" мяукнул 5 раз
    public void visit(String visit_date, String visit_result) {
       //Добавляем визит во множество 
       //Дата визита и резудбьтат осмотра
       this.visits.put(visit_date, visit_result);
    } 

    public int age() {
        LocalDate today = LocalDate.now();
        return today.getYear() - this.birthyear;
    }

    public void printVisits() {//Выводим все визиты в консоль
        System.out.println(this.visits); // []
    }

    public void miay() {//Выводим все визиты в консоль
        System.out.printf("кот %s мяукнул 5 раз\n",this.name ); // []
    }
}
